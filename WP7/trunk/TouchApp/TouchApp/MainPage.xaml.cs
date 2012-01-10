using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Shapes;
using Microsoft.Phone.Controls;

namespace TouchApp
{
    public partial class MainPage : PhoneApplicationPage
    {
        // コンストラクター
        public MainPage()
        {
            InitializeComponent();
            Touch.FrameReported += new TouchFrameEventHandler(TouchFrameReported);
        }

        private void TouchFrameReported(object sender, TouchFrameEventArgs e)
        {
            TouchPoint touchPoint = e.GetPrimaryTouchPoint(null);

            switch (touchPoint.Action)
            {
                case TouchAction.Down:
                    textBlock1.Text = "Down \nX:" + touchPoint.Position.X + "\tY:" + touchPoint.Position.Y;
                    break;
                case TouchAction.Move:
                    textBlock1.Text = "Move \nX:" + touchPoint.Position.X + "\tY:" + touchPoint.Position.Y;
                    break;
                case TouchAction.Up:
                    textBlock1.Text = "Up \nX:" + touchPoint.Position.X + "\tY:" + touchPoint.Position.Y;
                    break;
            }

            
        }
    }
}