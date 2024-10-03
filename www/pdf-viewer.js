var exec = require("cordova/exec");
var PLUGIN_NAME = "PDFViewer";

exports.loadPDFFromURL = function (success, error, args) {
	exec(success, error, PLUGIN_NAME, "loadPDFfromURL", [args]);
};
