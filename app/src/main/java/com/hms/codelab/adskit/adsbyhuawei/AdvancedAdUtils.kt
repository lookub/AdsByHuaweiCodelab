package com.hms.codelab.adskit.adsbyhuawei

import android.util.Log
import com.huawei.hms.ads.AdParam

class AdvancedAdUtils {

    companion object {

        private val TAG = AdvancedAdUtils::class.java.simpleName

        /**
         * Set Customize ad RequestOptions parameters
         *
         * @param nonPersonalizedAd       =  0, 1 : ALL
         * @param tagForChildProtection   = -1, 0, 1.  UNSPECIFIED, FALSE, TRUE -> Process ad requests according to the COPPA.
         * @param tagForUnderAgeOfPromise = -1, 0, 1.  UNSPECIFIED, FALSE, TRUE -> -> Process ad requests according to the GDPR.
         * @param adContentClassification = W, PI, J, A, "" : widespread audiences,  audiences with parental guidance, junior and older audiences, only for adults, UNKOWN
         * @return AdParam
         *
         *
         * more details : https://developer.huawei.com/consumer/en/doc/development/HMSCore-References-V5/requestoptions-0000001050066843-V5
         * more details : https://developer.huawei.com/consumer/en/doc/HMSCore-Guides-V5/publisher-service-advanced-settings-0000001050064972-V5
         */
        fun editAndGetAdParam(
            nonPersonalizedAd: Int, tagForChildProtection: Int,
            tagForUnderAgeOfPromise: Int, adContentClassification: String?
        ): AdParam? {
            val builder = AdParam.Builder()
            try {
                builder.setTagForChildProtection(tagForChildProtection)
            } catch (e: Exception) {
                Log.e(TAG, "editAndGetAdParam.setTagForChildProtection exception : " + e.message, e)
            }
            try {
                builder.setNonPersonalizedAd(nonPersonalizedAd)
            } catch (e: Exception) {
                Log.e(TAG,"editAndGetAdParam.setNonPersonalizedAd exception : " + e.message,e)
            }
            try {
                builder.setTagForUnderAgeOfPromise(tagForUnderAgeOfPromise)
            } catch (e: Exception) {
                Log.e(TAG,"editAndGetAdParam.setTagForUnderAgeOfPromise exception : " + e.message,e)
            }
            try {
                builder.setAdContentClassification(adContentClassification)
            } catch (e: Exception) {
                Log.e(TAG,"editAndGetAdParam.setAdContentClassification exception : " + e.message,e)
            }
            return builder.build()
        }


        fun getDetailsFromErrorCode(errorCode: Int): String? {
            return when (errorCode) {
                AdParam.ErrorCode.INNER -> "ERROR: 0 : INNER "
                AdParam.ErrorCode.INVALID_REQUEST -> "ERROR: 1 : INVALID_REQUEST"
                AdParam.ErrorCode.NETWORK_ERROR -> "ERROR: 2 : NETWORK_ERROR"
                AdParam.ErrorCode.NO_AD -> "ERROR: 3 : NO_AD"
                AdParam.ErrorCode.AD_LOADING -> "ERROR: 4 : AD_LOADING"
                AdParam.ErrorCode.LOW_API -> "ERROR: 5 : LOW_API"
                AdParam.ErrorCode.BANNER_AD_EXPIRE -> "ERROR: 6 : BANNER_AD_EXPIRE"
                AdParam.ErrorCode.BANNER_AD_CANCEL -> "ERROR: 7 : BANNER_AD_CANCEL"
                AdParam.ErrorCode.HMS_NOT_SUPPORT_SET_APP -> "ERROR: 8 : HMS_NOT_SUPPORT_SET_APP"
                else -> ""
            }
        }

        /**
         * ! All These customise parameters not supported some region adn some state. getting error !
         *
         * @param targetingContentUrl     = ?
         * @param gender                  = 0 : unKnow, 1 : male, 2 : female
         * @param requestOrigin           = ?
         * @param belongCountryCode       = ? such as 'TR'
         * @param tagForChildProtection   = -1, 0, 1.  UNSPECIFIED, FALSE, TRUE -> Process ad requests according to the COPPA.
         * @param nonPersonalizedAd       = 0, 1 : ALL
         * @param appLang                 = such as 'tr-TR'
         * @param appCountry              = such as 'Turkey'
         * @param tagForUnderAgeOfPromise = -1, 0, 1.  UNSPECIFIED, FALSE, TRUE -> -> Process ad requests according to the GDPR.
         * @param adContentClassification = W, PI, J, A : widespread audiences,  audiences with parental guidance, junior and older audiences, only for adults,
         * @return AdParam
         *
         *
         * more details : https://developer.huawei.com/consumer/en/doc/development/HMSCore-References-V5/requestoptions-0000001050066843-V5
         * more details : https://developer.huawei.com/consumer/en/doc/HMSCore-Guides-V5/publisher-service-advanced-settings-0000001050064972-V5
         */
        fun editAndGetAdParamWithAll(
            targetingContentUrl: String?, gender: Int, requestOrigin: String?,
            belongCountryCode: String?, tagForChildProtection: Int, nonPersonalizedAd: Int,
            appLang: String?, appCountry: String?, tagForUnderAgeOfPromise: Int,
            adContentClassification: String?
        ): AdParam? {
            val builder = AdParam.Builder()
            try {
                builder.setTargetingContentUrl(targetingContentUrl)
            } catch (e: Exception) {
                Log.e(TAG,"editAndGetAdParam.setTargetingContentUrl exception : " + e.message,e)
            }
            try {
                builder.setGender(gender)
            } catch (e: Exception) {
                Log.e(TAG, "editAndGetAdParam.setGender exception : " + e.message, e)
            }
            try {
                builder.setRequestOrigin(requestOrigin)
            } catch (e: Exception) {
                Log.e(TAG,"editAndGetAdParam.setRequestOrigin exception : " + e.message,e)
            }
            try {
                builder.setBelongCountryCode(belongCountryCode)
            } catch (e: Exception) {
                Log.e(TAG,"editAndGetAdParam.setBelongCountryCode exception : " + e.message,e)
            }
            try {
                builder.setTagForChildProtection(tagForChildProtection)
            } catch (e: Exception) {
                Log.e(TAG,"editAndGetAdParam.setTagForChildProtection exception : " + e.message,e)
            }
            try {
                builder.setNonPersonalizedAd(nonPersonalizedAd)
            } catch (e: Exception) {
                Log.e(TAG,"editAndGetAdParam.setNonPersonalizedAd exception : " + e.message,e)
            }
            try {
                builder.setAppLang(appLang)
            } catch (e: Exception) {
                Log.e(TAG, "editAndGetAdParam.setAppLang exception : " + e.message, e)
            }
            try {
                builder.setAppCountry(appCountry)
            } catch (e: Exception) {
                Log.e(TAG,"editAndGetAdParam.setAppCountry exception : " + e.message,e)
            }
            try {
                builder.setTagForUnderAgeOfPromise(tagForUnderAgeOfPromise)
            } catch (e: Exception) {
                Log.e(TAG,"editAndGetAdParam.setTagForUnderAgeOfPromise exception : " + e.message,e)
            }
            try {
                builder.setAdContentClassification(adContentClassification)
            } catch (e: Exception) {
                Log.e(TAG,"editAndGetAdParam.setAdContentClassification exception : " + e.message,e)
            }
            return builder.build()
        }
    }

}