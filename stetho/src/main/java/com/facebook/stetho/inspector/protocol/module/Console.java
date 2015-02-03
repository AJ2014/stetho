// Copyright 2004-present Facebook. All Rights Reserved.

package com.facebook.stetho.inspector.protocol.module;

import android.annotation.SuppressLint;

import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;

import org.json.JSONObject;

public class Console implements ChromeDevtoolsDomain {
  public Console() {
  }

  @ChromeDevtoolsMethod
  public void enable(JsonRpcPeer peer, JSONObject params) {
  }

  @ChromeDevtoolsMethod
  public void disable(JsonRpcPeer peer, JSONObject params) {
  }

  @SuppressLint({ "UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse" })
  public static class MessageAddedRequest {
    @JsonProperty(required = true)
    public ConsoleMessage message;
  }

  @SuppressLint({ "UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse" })
  public static class ConsoleMessage {
    @JsonProperty(required = true)
    public MessageSource source;

    @JsonProperty(required = true)
    public MessageLevel level;

    @JsonProperty(required = true)
    public String text;
  }

  public enum MessageSource {
    XML("xml"),
    JAVASCRIPT("javascript"),
    NETWORK("network"),
    CONSOLE_API("console-api"),
    STORAGE("storage"),
    APPCACHE("appcache"),
    RENDERING("rendering"),
    CSS("css"),
    SECURITY("security"),
    OTHER("other");

    private final String mProtocolValue;

    private MessageSource(String protocolValue) {
      mProtocolValue = protocolValue;
    }

    @JsonValue
    public String getProtocolValue() {
      return mProtocolValue;
    }
  }

  public enum MessageLevel {
    LOG("log"),
    WARNING("warning"),
    ERROR("error"),
    DEBUG("debug");

    private final String mProtocolValue;

    private MessageLevel(String protocolValue) {
      mProtocolValue = protocolValue;
    }

    @JsonValue
    public String getProtocolValue() {
      return mProtocolValue;
    }
  }

  @SuppressLint({ "UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse" })
  public static class CallFrame {
    @JsonProperty(required = true)
    public String functionName;

    @JsonProperty(required = true)
    public String url;

    @JsonProperty(required = true)
    public int lineNumber;

    @JsonProperty(required = true)
    public int columnNumber;

    public CallFrame() {
    }

    public CallFrame(String functionName, String url, int lineNumber, int columnNumber) {
      this.functionName = functionName;
      this.url = url;
      this.lineNumber = lineNumber;
      this.columnNumber = columnNumber;
    }
  }
}