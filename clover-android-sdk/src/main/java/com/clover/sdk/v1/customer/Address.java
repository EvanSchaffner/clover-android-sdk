/*
 * Copyright (C) 2013 Clover Network, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.clover.sdk.v1.customer;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A class representing an address associated with a customer. Instances of this object are returned
 * by the {@link com.clover.sdk.v1.customer.ICustomerService#addAddress(String customerId, String address1,
 * String address2, String city, String state, String zip, ResultStatus resultStatus)} method or as part of a
 * {@link com.clover.sdk.v1.customer.Customer} object.
 */
public class Address implements Parcelable {
  private final JSONObject data;


  Address(String json) throws JSONException {
    this.data = new JSONObject(json);
  }

  Address(Parcel in) throws JSONException {
    String json = in.readString();
    this.data = new JSONObject(json);
  }

  public Address(JSONObject data) {
    this.data = data;
  }

  public String getId() {
    return data.optString("id", null);
  }

  public String getAddress1() {
    return data.optString("address1", null);
  }

  public String getAddress2() {
    return data.optString("address2", null);
  }

  public String getCity() {
    return data.optString("city", null);
  }

  public String getState() {
    return data.optString("state", null);
  }

  public String getZip() {
    return data.optString("zip", null);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    String json = data.toString();
    dest.writeString(json);
  }

  public static final Creator<Address> CREATOR = new Creator<Address>() {
    public Address createFromParcel(Parcel in) {
      try {
        return new Address(in);
      } catch (JSONException e) {
        throw new RuntimeException(e);
      }
    }

    public Address[] newArray(int size) {
      return new Address[size];
    }
  };
}