﻿using GrabzIt.Enums;
using System;
using System.Collections.Generic;
using System.Text;

namespace GrabzIt.COM
{
    interface ITableOptions
    {
        Country Country
        {
            get;
            set;
        }

        string CustomId
        {
            get;
            set;
        }

        int TableNumberToInclude
        {
            get;
            set;
        }

        TableFormat Format
        {
            get;
            set;
        }

        bool IncludeHeaderNames
        {
            get;
            set;
        }

        bool IncludeAllTables
        {
            get;
            set;
        }

        string TargetElement
        {
            get;
            set;
        }

        BrowserType RequestAs
        {
            get;
            set;
        }
    }
}
