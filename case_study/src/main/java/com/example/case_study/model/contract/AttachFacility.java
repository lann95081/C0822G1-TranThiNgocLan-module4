package com.example.case_study.model.contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int attachFacilityId;
    private String attachFacilityName;
    private String attachFacilityCost;
    private String attachFacilityUnit;
    private String attachFacilityStatus;

    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetails;

    public AttachFacility() {
    }

    public int getAttachFacilityId() {
        return attachFacilityId;
    }

    public void setAttachFacilityId(int attachFacilityId) {
        this.attachFacilityId = attachFacilityId;
    }

    public String getAttachFacilityName() {
        return attachFacilityName;
    }

    public void setAttachFacilityName(String attachFacilityName) {
        this.attachFacilityName = attachFacilityName;
    }

    public String getAttachFacilityCost() {
        return attachFacilityCost;
    }

    public void setAttachFacilityCost(String attachFacilityCost) {
        this.attachFacilityCost = attachFacilityCost;
    }

    public String getAttachFacilityUnit() {
        return attachFacilityUnit;
    }

    public void setAttachFacilityUnit(String attachFacilityUnit) {
        this.attachFacilityUnit = attachFacilityUnit;
    }

    public String getAttachFacilityStatus() {
        return attachFacilityStatus;
    }

    public void setAttachFacilityStatus(String attachFacilityStatus) {
        this.attachFacilityStatus = attachFacilityStatus;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
