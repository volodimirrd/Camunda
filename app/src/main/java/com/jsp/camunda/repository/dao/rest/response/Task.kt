package com.jsp.camunda.repository.dao.rest.response

import com.google.gson.annotations.SerializedName

data class Task(
        @SerializedName("id") var id: String,
        @SerializedName("name") var name: String,
        @SerializedName("assignee") var assignee: String,
        @SerializedName("created") var created: String,
        @SerializedName("due") var due: String,
        @SerializedName("followUp") var followUp: String,
        @SerializedName("delegationState") var delegationState: String?,
        @SerializedName("description") var description: String,
        @SerializedName("executionId") var executionId: String,
        @SerializedName("owner") var owner: String?,
        @SerializedName("parentTaskId") var parentTaskId: String?,
        @SerializedName("priority") var priority: Int,
        @SerializedName("processDefinitionId") var processDefinitionId: String?,
        @SerializedName("processInstanceId") var processInstanceId: String?,
        @SerializedName("taskDefinitionKey") var taskDefinitionKey: String?,
        @SerializedName("caseExecutionId") var caseExecutionId: String?,
        @SerializedName("caseInstanceId") var caseInstanceId: String?,
        @SerializedName("caseDefinitionId") var caseDefinitionId: String?,
        @SerializedName("suspended") var suspended: Boolean?,
        @SerializedName("formKey") var formKey: String?,
        @SerializedName("tenantId") var tenantId: String?
)
