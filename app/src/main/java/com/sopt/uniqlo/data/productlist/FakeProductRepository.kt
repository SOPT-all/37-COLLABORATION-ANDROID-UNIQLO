package com.sopt.uniqlo.data.productlist

import com.sopt.uniqlo.domain.productlist.entity.ProductEntity
import com.sopt.uniqlo.domain.productlist.repository.ProductRepository
import javax.inject.Inject

class FakeProductRepository @Inject constructor() : ProductRepository {

    override suspend fun getProducts(): Result<List<ProductEntity>> {
        val dummyList = listOf(
            ProductEntity(
                id = 1L,
                imageUrl = "https://image.msscdn.net/thumbnails/images/goods_img/20250918/5486967/5486967_17617819130539_big.jpg?w=1200",
                colorHexCodes = listOf("#000000", "#111111", "#222222", "#FFFFFF"),
                genderAndSizeRange = "WOMEN, XS~3XL",
                name = "밀라노립니트재킷",
                originalPrice = "49,900",
                salePrice = "39,900",
                productTag = "온라인단독",
                starAverage = 5.0f,
                reviewCount = 10
            ),
            ProductEntity(
                id = 2L,
                imageUrl = "https://image.msscdn.net/thumbnails/images/goods_img/20250918/5488701/5488701_17617818112680_big.jpg?w=1200",
                colorHexCodes = listOf("#828388", "#303030", "#3D2D2D"),
                genderAndSizeRange = "WOMEN, XS~XXL",
                name = "더블브레스트재킷(셋업가능)",
                originalPrice = "89,900",
                salePrice = null,
                productTag = "일부매장제품",
                starAverage = 4.6f,
                reviewCount = 3
            )
        ) + List(18) { id ->
            ProductEntity(
                id = id + 3L,
                imageUrl = "https://image.msscdn.net/thumbnails/images/goods_img/20250808/5303307/5303307_17569422514451_big.jpg?w=1200",
                colorHexCodes = listOf("#000000", "#111111"),
                genderAndSizeRange = "MEN, S~3XL",
                name = "베이직 티셔츠 ${id + 3}",
                originalPrice = "29,900",
                salePrice = null,
                productTag = null,
                starAverage = 4.2f,
                reviewCount = 100 + id
            )
        }

        return Result.success(dummyList)
    }
}