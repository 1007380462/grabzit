﻿using GrabzIt.Enums;
using System;
using System.Collections.Generic;
using System.Text;

namespace GrabzIt.COM
{
    interface IImageOptions
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

        int BrowserWidth
        {
            get;
            set;
        }

        int BrowserHeight
        {
            get;
            set;
        }

        int OutputHeight
        {
            get;
            set;
        }

        int OutputWidth
        {
            get;
            set;
        }

        ImageFormat Format
        {
            get;
            set;
        }

        int Delay
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

        string CustomWaterMarkId
        {
            get;
            set;
        }
    
        int Quality
        {
            get;
            set;
        }
    }
}
