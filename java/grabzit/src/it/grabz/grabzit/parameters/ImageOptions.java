/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.grabz.grabzit.parameters;

import it.grabz.grabzit.enums.BrowserType;
import it.grabz.grabzit.enums.ImageFormat;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Contains all of the available options when creating a image capture.
 * 
 * @version 3.0
 * @author GrabzIt
 */
public class ImageOptions extends BaseOptions {
    private int browserWidth;
    private int browserHeight;
    private int outputWidth;
    private int outputHeight;
    private ImageFormat format;
    private String targetElement;
    private BrowserType requestAs;
    private String customWaterMarkId;
    private int quality;

    public ImageOptions()
    {
        this.browserHeight = 0;
        this.browserWidth = 0;
        this.outputHeight = 0;
        this.outputWidth = 0;
        this.format = ImageFormat.JPG;
        this.targetElement = "";
        this.requestAs = BrowserType.STANDARDBROWSER;
        this.customWaterMarkId = "";
        this.quality = -1;
    }
    
    /**
     * @return the width of the browser in pixels.
     */
    public int getBrowserWidth() {
        return browserWidth;
    }

    /**
     * @param browserWidth set the width of the browser in pixels.
     */
    public void setBrowserWidth(int browserWidth) {
        this.browserWidth = browserWidth;
    }

    /**
     * @return the height of the browser in pixels.
     */
    public int getBrowserHeight() {
        return browserHeight;
    }

    /**
     * @param browserHeight set the height of the browser in pixels. Use -1 to screenshot the whole web page.
     */
    public void setBrowserHeight(int browserHeight) {
        this.browserHeight = browserHeight;
    }

    /**
     * @return the width of the resulting screenshot in pixels.
     */
    public int getOutputWidth() {
        return outputWidth;
    }

    /**
     * @param outputWidth set the width of the resulting screenshot in pixels. Use -1 to not reduce the width of the screenshot.
     */
    public void setOutputWidth(int outputWidth) {
        this.outputWidth = outputWidth;
    }

    /**
     * @return get the height of the resulting screenshot in pixels.
     */
    public int getOutputHeight() {
        return outputHeight;
    }

    /**
     * @param outputHeight set the height of the resulting screenshot in pixels. Use -1 to not reduce the height of the screenshot.
     */
    public void setOutputHeight(int outputHeight) {
        this.outputHeight = outputHeight;
    }

    /**
     * @return the format of the screenshot image.
     */
    public ImageFormat getFormat() {
        return format;
    }

    /**
     * @param format set the format the screenshot should be in: bmp8, bmp16, bmp24, bmp, tiff, jpg, png.
     */
    public void setFormat(ImageFormat format) {
        this.format = format;
    }

    /**
     * @return the number of milliseconds to wait before creating the capture.
     */
    public int getDelay() {
        return delay;
    }

    /**
     * @param delay set the number of milliseconds to wait before creating the capture.
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }

    /**
     * @return get the id of the only HTML element in the web page to turn into a screenshot.
     */
    public String getTargetElement() {
        return targetElement;
    }

    /**
     * @param targetElement set the id of the only HTML element in the web page to turn into a screenshot.
     */
    public void setTargetElement(String targetElement) {
        this.targetElement = targetElement;
    }

    /**
     * @return get which user agent type should be used.
     */
    public BrowserType getRequestAs() {
        return requestAs;
    }

    /**
     * @param requestAs set which user agent type should be used.
     */
    public void setRequestAs(BrowserType requestAs) {
        this.requestAs = requestAs;
    }

    /**
     * @return the custom watermark id.
     */
    public String getCustomWaterMarkId() {
        return customWaterMarkId;
    }

    /**
     * @param customWaterMarkId set a custom watermark to add to the screenshot.
     */
    public void setCustomWaterMarkId(String customWaterMarkId) {
        this.customWaterMarkId = customWaterMarkId;
    }

    /**
     * @return the quality of the screenshot.
     */
    public int getQuality() {
        return quality;
    }

    /**
     * @param quality set the quality of the screenshot where 0 is poor and 100 excellent. The default is -1 which uses the recommended quality.
     */
    public void setQuality(int quality) {
        this.quality = quality;
    }
    
    @Override
    public String _getSignatureString(String applicationSecret, String callBackURL, String url)
    {
        String urlParam = "";
        if (url != null && !"".equals(url))
        {
            urlParam = ParameterUtility.nullCheck(url)+"|";
        }		

        String callBackURLParam = "";
        if (callBackURL != null && !"".equals(callBackURL))
        {
            callBackURLParam = ParameterUtility.nullCheck(callBackURL);
        }				

        return ParameterUtility.nullCheck(applicationSecret) + "|" + urlParam + callBackURLParam
        + "|" + format.getValue() + "|" + outputHeight + "|" + outputWidth + "|" + browserHeight 
        + "|" + browserWidth + "|" + getCustomId() + "|" + delay + "|" + targetElement + "|" + customWaterMarkId 
        + "|" + requestAs.getValue() + "|" + getCountry().getValue() + "|" + quality;
    }    
    
    @Override
    public HashMap<String, String>  _getParameters(String applicationKey, String sig, String callBackURL, String dataName, String dataValue) throws UnsupportedEncodingException
    {
        HashMap<String, String> params = createParameters(applicationKey, sig, callBackURL, dataName, dataValue);		
        params.put("target", ParameterUtility.encode(ParameterUtility.nullCheck(targetElement)));
        params.put("requestmobileversion", String.valueOf(requestAs.getValue()));
	params.put("width", String.valueOf(outputWidth));
	params.put("height", String.valueOf(outputHeight));
	params.put("format", format.getValue());
	params.put("bwidth", String.valueOf(browserWidth));
	params.put("customwatermarkid", ParameterUtility.encode(ParameterUtility.nullCheck(customWaterMarkId)));
	params.put("bheight", String.valueOf(browserHeight));
	params.put("delay", String.valueOf(delay));
	params.put("quality", String.valueOf(quality));        
        
        return params;
    }    
}