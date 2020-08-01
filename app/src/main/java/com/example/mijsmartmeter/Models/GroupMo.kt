package com.example.mijsmartmeter.Models

class GroupMo {
    var gname: String? = null
    var mname: String? = null
    var snumber: String? = null

    constructor() {}
    constructor(gname: String?, mname: String?, snumber: String?) {
        this.gname = gname
        this.mname = mname
        this.snumber = snumber
    }

}