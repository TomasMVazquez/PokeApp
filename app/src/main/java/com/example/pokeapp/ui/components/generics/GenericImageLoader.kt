package com.example.pokeapp.ui.components.generics

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.LocalImageLoader
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation

enum class ImageType {
    NORMAL,
    CIRCLE,
    ROUNDED
}

/**
 * Need to add COIL Implementation: https://coil-kt.github.io/coil/compose/
 */
@Composable
fun GenericImageLoader(
    modifier: Modifier = Modifier,
    type: ImageType,
    url: String?,
    description: String,
    contentScale: ContentScale = ContentScale.Crop
) {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .componentRegistry {
            add(SvgDecoder(LocalContext.current))
        }
        .build()

    CompositionLocalProvider(LocalImageLoader provides imageLoader) {

        when(type){
            ImageType.CIRCLE -> {
                CircleImage(
                    url = url,
                    description = description,
                    contentScale = contentScale,
                    modifier = modifier
                )
            }
            ImageType.ROUNDED -> {
                RoundedImage(
                    url = url,
                    description = description,
                    contentScale = contentScale,
                    modifier = modifier
                )
            }
            ImageType.NORMAL -> {
                NormalImage(
                    url = url,
                    description = description,
                    contentScale = contentScale,
                    modifier = modifier
                )
            }
        }
    }
}

@Composable
fun CircleImage(
    url: String?,
    description: String,
    contentScale: ContentScale,
    modifier: Modifier
) {
    Image(
        painter = rememberImagePainter(
            data = url,
            builder = {
                transformations(CircleCropTransformation())
                crossfade(true)
            }
        ),
        contentDescription = description,
        contentScale = contentScale,
        modifier = modifier
    )
}

@Composable
fun RoundedImage(
    url: String?,
    description: String,
    contentScale: ContentScale,
    modifier: Modifier
) {
    Image(
        painter = rememberImagePainter(
            data = url,
            builder = {
                transformations(RoundedCornersTransformation(16F))
                crossfade(true)
            }
        ),
        contentDescription = description,
        contentScale = contentScale,
        modifier = modifier
    )
}

@Composable
fun NormalImage(
    url: String?,
    description: String,
    contentScale: ContentScale,
    modifier: Modifier
) {
    Image(
        painter = rememberImagePainter(
            data = url,
            builder = {
                crossfade(true)
            }
        ),
        contentDescription = description,
        contentScale = contentScale,
        modifier = modifier
    )
}