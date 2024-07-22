# Onboarding Screen Using Circular Progress Bar

Custom onboarding UI with MVVM architecture, data preferences, and Canva-based design.

## Features

- MVVM architecture
- DataStore preferences for saving app entry state
- Custom Canva design for onboarding UI
- Circular progress indicator

## Screenshots
### Dark Mode :
<div style="display: flex; justify-content: center; align-items: center;">
    <img src="https://github.com/user-attachments/assets/7ddaeb72-9798-43e3-9f5c-aad186761e43" alt="First Screenshot" style="width: 200px; height: auto; margin-right: 10px;">
    <img src="https://github.com/user-attachments/assets/f9371984-6db7-476b-8c2d-3714d6bfe296" alt="Second Screenshot" style="width: 200px; height: auto; margin-right: 10px;">
    <img src="https://github.com/user-attachments/assets/bde33a77-746f-42ed-ad2a-cfbd7ac992f4" alt="Third Screenshot" style="width: 200px; height: auto;">
</div>

### Light Mode :
<div style="display: flex; justify-content: center; align-items: center;">
    <img src="https://github.com/user-attachments/assets/4abcba3f-61d3-4496-902e-980727777c71" alt="First Screenshot" style="width: 200px; height: auto; margin-right: 10px;">
    <img src="https://github.com/user-attachments/assets/a2fd5151-a60e-4c99-9a52-cd291cbfdf18" alt="Second Screenshot" style="width: 200px; height: auto; margin-right: 10px;">
    <img src="https://github.com/user-attachments/assets/43db7486-9096-4c2d-8deb-bc02db6d3aaa" alt="Third Screenshot" style="width: 200px; height: auto;">
</div>

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Bhavyansh03-tech/Circular_ProgressBar_Onboarding_Screen.git
   ```
2. Open the project in Android Studio.
3. Build and run the project on an Android device or emulator.

## Usage

### ClippedImage Composable

```kotlin
@Composable
fun ClippedImage(shapeImageId: Int, contentImageId: Int) {
    val context = LocalContext.current
    val shapeBitmap = BitmapFactory.decodeStream(context.resources.openRawResource(shapeImageId))
    val contentBitmap = BitmapFactory.decodeStream(context.resources.openRawResource(contentImageId))

    val shapeImageBitmap = shapeBitmap.asImageBitmap()
    val contentImageBitmap = contentBitmap.asImageBitmap()

    Canvas(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.6f)) {

        drawIntoCanvas { canvas ->
            canvas.withSaveLayer(Rect(0f, 0f, size.width, size.height), Paint()) {
                // Draw the shape image as a mask
                drawImage(
                    image = shapeImageBitmap,
                    dstSize = IntSize(size.width.toInt(), size.height.toInt())
                )

                // Clip the content image within the shape
                drawImage(
                    image = contentImageBitmap,
                    dstSize = IntSize(size.width.toInt(), size.height.toInt()),
                    blendMode = BlendMode.SrcIn
                )
            }
        }
    }
}
```

### CircularProgressBar Composable

```kotlin
@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier,
    progress: Float,
    color: Color,
    stroke: Dp
) {
    CircularProgressIndicator(
        progress = { progress },
        modifier = modifier,
        color = color,
        strokeWidth = stroke,
    )
}
```

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any improvements or bug fixes.

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Create a new Pull Request.

## Contact

For questions or feedback, please contact [@Bhavyansh03-tech](https://github.com/Bhavyansh03-tech).

---
