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

namespace SliderApp
{
    public partial class MainPage : PhoneApplicationPage
    {
        // コンストラクター
        public MainPage()
        {
            InitializeComponent();
            textBlock1.Text = "value: " + slider1.Value.ToString("f1");
        }

        private void SliderValueChanged(object sender,
                RoutedPropertyChangedEventArgs<double> e)
        {
            try
            {
                Slider s = (Slider)sender;
                textBlock1.Text = "value: " + s.Value.ToString("f1");  
            }
            catch (NullReferenceException ex) { }
        }
    }
}