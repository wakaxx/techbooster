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
using System.Windows.Threading;

namespace TimerApp
{
    public partial class MainPage : PhoneApplicationPage
    {

        private DispatcherTimer mTimer;
        private double mTime = 0.0;

        // コンストラクター
        public MainPage()
        {
            InitializeComponent();
            mTimer = new DispatcherTimer();
            mTimer.Interval = TimeSpan.FromMilliseconds(100);
            mTimer.Tick += new EventHandler(TickTimer);
            textTime.Text = mTime.ToString();
            btnStartStop.Content = "start";
            
        }

        private void ClickButton(object sender, RoutedEventArgs e)
        {
            if (mTimer.IsEnabled)
            {
                btnStartStop.Content = "start";
                mTimer.Stop();
            }
            else
            {
                btnStartStop.Content = "stop";
                mTime = 0.0;
                textTime.Text = mTime.ToString("f1");
                mTimer.Start();
            }
        }

        void TickTimer(object sender, EventArgs e)
        {
            mTime += 0.1;
            textTime.Text = mTime.ToString("f1");
        }
    }
}