/*
 * Copyright (c) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.ims;

import android.net.Uri;
import android.telephony.ims.ImsReasonInfo;
import android.telephony.ims.feature.ImsFeature;
import android.telephony.ims.stub.ImsRegistrationImplBase;

/**
 * Listener for receiving notifications about changes to the IMS connection.
 * It provides a state of IMS registration between UE and IMS network, the service
 * availability of the local device during IMS registered.
 * @Deprecated Use {@link ImsRegistrationImplBase.Callback} instead.
 * @hide
 */
public class ImsConnectionStateListener extends ImsRegistrationImplBase.Callback {

    @Override
    public final void onRegistered(@ImsRegistrationImplBase.ImsRegistrationTech int imsRadioTech) {
        onImsConnected(imsRadioTech);
    }

    @Override
    public final void onRegistering(@ImsRegistrationImplBase.ImsRegistrationTech int imsRadioTech) {
        onImsProgressing(imsRadioTech);
    }

    @Override
    public final void onDeregistered(ImsReasonInfo info) {
        onImsDisconnected(info);
    }

    @Override
    public final void onTechnologyChangeFailed(
            @ImsRegistrationImplBase.ImsRegistrationTech int imsRadioTech, ImsReasonInfo info) {
        onRegistrationChangeFailed(imsRadioTech, info);
    }

    @Override
    public void onSubscriberAssociatedUriChanged(Uri[] uris) {
        registrationAssociatedUriChanged(uris);
    }
    /**
     * Called when the device is connected to the IMS network with {@param imsRadioTech}.
     */
    public void onImsConnected(int imsRadioTech) {
        // no-op
    }

    /**
     * Called when the device is trying to connect to the IMS network with {@param imsRadioTech}.
     */
    public void onImsProgressing(int imsRadioTech) {
        // no-op
    }

    /**
     * Called when the device is disconnected from the IMS network.
     */
    public void onImsDisconnected(ImsReasonInfo imsReasonInfo) {
        // no-op
    }

    /**
     * Called when its suspended IMS connection is resumed, meaning the connection
     * now allows throughput.
     * @deprecated not used in newer IMS provider implementations.
     */
    public void onImsResumed() {
        // no-op
    }

    /**
     * Called when its current IMS connection is suspended, meaning there is no data throughput.
     * @deprecated not used in newer IMS provider implementations.
     */
    public void onImsSuspended() {
        // no-op
    }

    /**
     * Called when its current IMS connection feature capability changes.
     * @deprecated Not used in newer IMS provider implementations.
     */
    public void onFeatureCapabilityChanged(int serviceClass,
                int[] enabledFeatures, int[] disabledFeatures) {
        // no-op
    }

    /**
     * Called when waiting voice message count changes.
     * @deprecated not used in newer IMS provider implementations.
     */
    public void onVoiceMessageCountChanged(int count) {
        // no-op
    }

    /**
     * Called after IMS registration.
     */
    public void registrationAssociatedUriChanged(Uri[] uris) {
        // no-op
    }

    /**
     * Called when IMS registration attempt on {@param imsRadioTech} failed
     */
    public void onRegistrationChangeFailed(int imsRadioTech, ImsReasonInfo imsReasonInfo) {
        // no-op
    }
}
