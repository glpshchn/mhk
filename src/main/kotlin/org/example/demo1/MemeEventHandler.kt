package org.example.demo1

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.diagnostic.Logger
import javax.swing.ImageIcon
import javax.swing.JOptionPane
import java.io.File

object MemeHandler {

    private val logger = Logger.getInstance(MemeHandler::class.java)

    fun showMeme(project: Project?) {
        // Логируем, что мем отображается
        logger.info("Displaying meme...")

        // Получаем путь к картинке из ресурсов
        val memeFile = File("/Users/glpshchn/IdeaProjects/demo1/src/main/resources/meme.png")

        // Проверяем, существует ли файл
        if (memeFile.exists()) {
            logger.info("Meme file found at: ${memeFile.absolutePath}")

            // Загружаем изображение
            val imageIcon = ImageIcon(memeFile.absolutePath)

            // Проверяем, успешно ли загрузилось изображение
            if (imageIcon.iconWidth <= 0 || imageIcon.iconHeight <= 0) {
                logger.error("Failed to load image, invalid dimensions.")
                Messages.showErrorDialog(project, "Image could not be loaded!", "Error")
            } else {
                // Показать изображение в диалоговом окне
                JOptionPane.showMessageDialog(null, null, "Here is your meme!", JOptionPane.INFORMATION_MESSAGE, imageIcon)
            }
        } else {
            // В случае ошибки (если изображение не найдено)
            logger.error("Meme image not found at path: ${memeFile.absolutePath}")
            Messages.showErrorDialog(project, "Meme image not found!", "Error")
        }
    }
}
