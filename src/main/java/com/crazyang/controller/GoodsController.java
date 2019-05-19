package com.crazyang.controller;

import com.alibaba.fastjson.JSONArray;
import com.crazyang.bo.GoodsBo;
import com.crazyang.core.common.Const;
import com.crazyang.core.redis.GoodsKey;
import com.crazyang.core.redis.RedisService;
import com.crazyang.result.CodeMsg;
import com.crazyang.result.Result;
import com.crazyang.service.GoodsService;
import com.crazyang.vo.GoodsDetailVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName GoodsController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/17 下午4:50.
 */
@Controller
@RequestMapping("/web/goods")
public class GoodsController {


    @Autowired
    RedisService redisService;
    @Autowired
    GoodsService goodsService;

    @ApiOperation(value = "查看商品所有商品", response = List.class)
    @GetMapping("/list")
    @ResponseBody
    //压力测试：10个线程，1000次请求
    //由于服务器性能问题：加缓存前16，加缓存后44；提高了接近3倍
    public Result list(Model model, HttpServletRequest request, HttpServletResponse response) {
        //1.缓存中取数据
        String str = redisService.get(GoodsKey.getGoodsList, "", String.class);
        //通过JSONArray将redis中的str转为List
        List<GoodsBo> goodsList = JSONArray.parseArray(str, GoodsBo.class);
//        List<GoodsBo> goodsList=null;
        //2.如果缓存已经存在数据，则从缓存中直接取数据
        if (!StringUtils.isEmpty(goodsList)) {
            return Result.success(goodsList);
        }
        //3.如果缓存没有数据，则从数据库中取数据；
        List<GoodsBo> lists = goodsService.getGoodsList();
        if (lists.size() > 0) {
            redisService.set(GoodsKey.getGoodsList, "", lists, Const.RedisCacheExtime.GOODS_LIST);
        }

        return Result.success(lists);
    }

    /**
     * 根据商品id查看商品详情
     *
     * @param goodsId
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/detail/{goodsId}")
    @ResponseBody
    public Result goodsDetail(Model model, @PathVariable long goodsId, HttpServletRequest request, HttpServletResponse response) {
        //
        GoodsBo goodsBo = goodsService.getseckillGoodsBoByGoodsId(goodsId);
        if (goodsBo == null) {
            return Result.error(CodeMsg.NO_GOODS);
        } else {
            model.addAttribute("goods", goodsBo);
            GoodsDetailVO vo = new GoodsDetailVO();
            vo.setGoods(goodsBo);
            return Result.success(vo);
        }
    }
}
