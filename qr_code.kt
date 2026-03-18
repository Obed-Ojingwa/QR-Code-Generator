import qrcode.QRCode
import qrcode.color.Colors
import java.io.File

fun main() {
    // Constants
    val mapsUrl = "https://maps.app.goo.gl/6qcM8WXkVjCNf4uh8"
    val outputFile = "location_qr.png"
    val qrBoxSize = 25 // Roughly equivalent to Python's box_size (pixels per square)
    val qrBorder = 4 

    println("Encoding URL: $mapsUrl")

    // Create QR Code
    // Note: Error Correction 'High' is used by default or can be specified
    val qrCode = QRCode(mapsUrl)
    
    // Generate the image data
    // .render() handles the sizing and colors
    val imageData = qrCode.render(
        cellSize = qrBoxSize,
        margin = qrBorder,
        brightColor = Colors.WHITE, // back_color
        darkColor = Colors.BLACK    // fill_color
    )

    // Save to file
    val file = File(outputFile)
    file.writeBytes(imageData.getBytes())

    println("QR code saved as: ${file.absolutePath}")
    println("Scan it to open: $mapsUrl")
}
