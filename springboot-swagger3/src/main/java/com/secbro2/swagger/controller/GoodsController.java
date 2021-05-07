package com.secbro2.swagger.controller;

import com.secbro2.swagger.entity.Goods;
import com.secbro2.swagger.entity.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author sec
 * @version 1.0
 * @date 2021/5/7
 **/
@Api(tags = "商品信息管理接口")
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Operation(summary = "单个商品详情")
    @GetMapping("/findGoodsById")
    public CommonResult<Goods> findGoodsById(
            @Parameter(description = "商品ID,正整数")
            @RequestParam(value = "goodsId", required = false, defaultValue = "0") Integer goodsId) {
        System.out.println("根据商品ID=" + goodsId + "查询商品详情");
        Goods goods = new Goods();
        goods.setGoodsId(1L);
        goods.setGoodsName("笔记本");
        goods.setPrice(new BigDecimal(8888));
        return CommonResult.success(goods);
    }
}
