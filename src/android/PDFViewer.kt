package com.outsystems.experts

import android.util.Log
import com.rajat.pdfviewer.PdfViewerActivity
import com.rajat.pdfviewer.util.saveTo
import org.apache.cordova.CallbackContext
import org.apache.cordova.CordovaInterface
import org.apache.cordova.CordovaPlugin
import org.apache.cordova.CordovaWebView
import org.apache.cordova.PluginResult
import org.json.JSONArray
import org.json.JSONException

class PDFViewer : CordovaPlugin() {
    companion object {
        private const val TAG = "PDFViewer"
    }

    override fun initialize(cordova: CordovaInterface, webView: CordovaWebView) {
        super.initialize(cordova, webView)
        Log.d(TAG, "Initializing MyCordovaPlugin")
    }

    @Throws(JSONException::class)
        override fun execute(action: String, args: JSONArray, callbackContext: CallbackContext): Boolean {
        try {
            if (action == "loadPDFfromURL") {
                PdfViewerActivity.launchPdfFromUrl(
                    context = this.cordova.context, // Replaced with appropriate context
                    pdfUrl = args.getString(0),
                    pdfTitle = "PDF Title",
                    saveTo = saveTo.ASK_EVERYTIME, // Replace SaveTo with the actual enum or class used
                    enableDownload = true
                ).also { intent ->
                    cordova.activity.startActivity(intent)
                    callbackContext.success()
                }
            }
        }
        catch (ex:Exception){
            callbackContext.error(ex.message)
        }
        return true
    }
}