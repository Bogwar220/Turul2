package com.bstan.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Candidate implements Parcelable {

    private String name;
    private long votes;

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Candidate(){}

    protected Candidate(Parcel in){
        name = in.readString();
        votes = in.readLong();
    }

    public static final Creator<Candidate> CREATOR = new Creator<Candidate>() {
        @Override
        public Candidate createFromParcel(Parcel in) {
            return new Candidate(in);
        }

        @Override
        public Candidate[] newArray(int size) {
            return new Candidate[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeLong(votes);
    }
}
