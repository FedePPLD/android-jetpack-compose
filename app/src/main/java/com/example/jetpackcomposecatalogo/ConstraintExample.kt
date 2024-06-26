package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun ConstraintExample1() {
    ConstraintLayout(Modifier.fillMaxSize()) {

        val (redBox, blueBox, yellowBox, magentaBox, cyanBox) = createRefs()

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        )

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Blue)
                .constrainAs(blueBox) {
                    top.linkTo(redBox.bottom)
                    start.linkTo(redBox.end)
                }
        )

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Cyan)
                .constrainAs(cyanBox) {
                    top.linkTo(redBox.bottom)
                    end.linkTo(redBox.start)
                }
        )

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    bottom.linkTo(redBox.top)
                    end.linkTo(redBox.start)
                }
        )

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    bottom.linkTo(redBox.top)
                    start.linkTo(redBox.end)
                }
        )
    }
}


@Composable
fun ConstraintExampleGuide() {
    ConstraintLayout(Modifier.fillMaxSize()) {

        val boxRed = createRef()
        // val startGuide = createGuidelineFromTop(16.dp)

        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.25f)

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(topGuide)
                    start.linkTo(startGuide)
                })
    }
}


@Composable
fun ConstraintBarrier() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed, boxGreen, boxYellow) = createRefs()
        val barrier = createEndBarrier(boxRed, boxGreen)

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )

        Box(
            Modifier
                .size(235.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(boxGreen.bottom)
                    start.linkTo(parent.start, margin = 32.dp)
                }

        )

        Box(
            Modifier
                .size(50.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(barrier)
                }
        )
    }
}


@Preview
@Composable
fun ConstraintChainExample() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed, boxGreen, boxYellow) = createRefs()

        Box(
            Modifier
                .size(75.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    start.linkTo(parent.start)
                    end.linkTo(boxRed.start)
                }
        )

        Box(
            Modifier
                .size(75.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    start.linkTo(boxGreen.end)
                    end.linkTo(boxYellow.start)
                }
        )

        Box(
            Modifier
                .size(75.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(boxRed.end)
                    end.linkTo(parent.end)
                }
        )

        createHorizontalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.SpreadInside)
    }
}