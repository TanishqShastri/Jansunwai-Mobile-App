package com.example.tanishqshastri_mppolice.jansunwai;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class complaintAdapter extends RecyclerView.Adapter<complaintAdapter.complaintViewHolder> {

    private Context mCtx;
    private List<complaint> complaintList;

    public complaintAdapter(Context mCtx, List<complaint> complaintList) {
        this.mCtx = mCtx;
        this.complaintList = complaintList;
    }

    @NonNull
    @Override
    public complaintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new complaintViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull complaintViewHolder holder, int position) {
        complaint complaint = complaintList.get(position);

        holder.tvid.setText(complaint.getId());
        holder.tvname.setText(complaint.getName());
        holder.tvaadhaar.setText(complaint.getAadhaar());
        holder.tvphone.setText(complaint.getPhone());
        holder.tvsubject.setText(complaint.getSubject());
        holder.tvdate.setText(complaint.getDate());
        holder.tvdescription.setText(complaint.getDescription());
        holder.tvchaipersonRemark.setText(complaint.getChairpersonRemark());

        String status = complaint.getApplicationStatus();
        if (status.equals("0")) {

            holder.tvapplicationStatus.setText("Application Submitted in Progress");
        } else if (status.equals("1")) {
            holder.tvapplicationStatus.setText("Forwarded to officer");
        } else if (status.equals("2")) {
            holder.tvapplicationStatus.setText("Officer Responded");
        } else if (status.equals("3")) {
            holder.tvapplicationStatus.setText("Application Rejected");
        } else {
            holder.tvapplicationStatus.setText("Application in Progress");
        }

        holder.tvofficerName.setText(complaint.getOfficername());
        holder.tvofficerRemark.setText(complaint.getOfficerRemark());
        holder.tvlastUpdated.setText(complaint.getLastupdate());

    }

    @Override
    public int getItemCount() {
        return complaintList.size();
    }

    class complaintViewHolder extends RecyclerView.ViewHolder {

        TextView tvid, tvname, tvaadhaar, tvphone, tvsubject, tvdate, tvdescription, tvchaipersonRemark, tvapplicationStatus, tvofficerName, tvofficerRemark, tvlastUpdated, tvkey;
        String statusX, status0, status1, status2;

        public complaintViewHolder(View itemView) {
            super(itemView);

            tvid = itemView.findViewById(R.id.tvApplicationID);
            tvname = itemView.findViewById(R.id.tvApplicantName);
            tvaadhaar = itemView.findViewById(R.id.tvApplicantAadhaar);
            tvphone = itemView.findViewById(R.id.tvApplicantPhone);
            tvsubject = itemView.findViewById(R.id.tvSubject);
            tvdate = itemView.findViewById(R.id.tvDate);
            tvdescription = itemView.findViewById(R.id.tvDescription);
            tvchaipersonRemark = itemView.findViewById(R.id.tvChairpersonRemark);
            tvapplicationStatus = itemView.findViewById(R.id.tvApplicationStatus);
            tvofficerName = itemView.findViewById(R.id.tvofficerName);
            tvofficerRemark = itemView.findViewById(R.id.tvOfficerRemark);
            tvlastUpdated = itemView.findViewById(R.id.tvlastUpdated);
            tvkey = itemView.findViewById(R.id.tvkey);

        }
    }
}