package org.example.demo1

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.diagnostic.Logger
import javax.swing.ImageIcon
import javax.swing.JOptionPane

class ShowMemeAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project
        if (project != null) {
            println("Action triggered! Calling showMeme...")
            MemeHandler.showMeme(project)
        } else {
            println("No project found.")
            Messages.showErrorDialog("No project found", "Error")
        }
    }
}

