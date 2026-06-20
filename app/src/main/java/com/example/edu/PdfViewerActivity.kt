/*
package com.example.edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView
import com.google.android.material.appbar.MaterialToolbar

class PdfViewerActivity : AppCompatActivity() {

    private lateinit var pdfView: PDFView
    private lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_viewer)

        pdfView = findViewById(R.id.pdfView)
        toolbar = findViewById(R.id.toolbar)

        val pdfName = intent.getStringExtra("pdf_name") ?: ""

        toolbar.title = pdfName

        toolbar.setNavigationOnClickListener {
            finish()
        }

        try {
            pdfView.fromAsset(pdfName)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .load()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}*/
package com.example.edu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView

class PdfViewerActivity : AppCompatActivity() {

    private lateinit var pdfView: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_viewer)

        pdfView = findViewById(R.id.pdfView)

        val pdfName = intent.getStringExtra("pdf_name")

        if (pdfName != null) {

            pdfView.fromAsset(pdfName)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .load()
        }
    }
}