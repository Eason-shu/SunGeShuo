// Generated by the protocol buffer compiler.  DO NOT EDIT!

package com.suns.nano;

@SuppressWarnings("hiding")
public interface SubscribeRespModel {

  public static final class SubscribeResp extends
      com.google.protobuf.nano.MessageNano {

    private static volatile SubscribeResp[] _emptyArray;
    public static SubscribeResp[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new SubscribeResp[0];
          }
        }
      }
      return _emptyArray;
    }

    // required int32 subReqID = 1;
    public int subReqID;

    // required int32 respCode = 2;
    public int respCode;

    // required string desc = 3;
    public String desc;

    public SubscribeResp() {
      clear();
    }

    public SubscribeResp clear() {
      subReqID = 0;
      respCode = 0;
      desc = "";
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      output.writeInt32(1, this.subReqID);
      output.writeInt32(2, this.respCode);
      output.writeString(3, this.desc);
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt32Size(1, this.subReqID);
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeInt32Size(2, this.respCode);
      size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeStringSize(3, this.desc);
      return size;
    }

    @Override
    public SubscribeResp mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 8: {
            this.subReqID = input.readInt32();
            break;
          }
          case 16: {
            this.respCode = input.readInt32();
            break;
          }
          case 26: {
            this.desc = input.readString();
            break;
          }
        }
      }
    }

    public static SubscribeResp parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new SubscribeResp(), data);
    }

    public static SubscribeResp parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new SubscribeResp().mergeFrom(input);
    }
  }
}
