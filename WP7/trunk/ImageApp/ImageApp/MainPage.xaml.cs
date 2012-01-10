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
using System.Windows.Media.Imaging;

namespace ImageApp
{
    public partial class MainPage : PhoneApplicationPage
    {
        // コンストラクター
        public MainPage()
        {
            InitializeComponent();
        }

        public void Image_Change(object sender, RoutedEventArgs e)
        {
            image1.Source = new BitmapImage(new Uri("/ImageApp;component/Images/i4rog.jpg", UriKind.RelativeOrAbsolute));
            image1.Stretch = Stretch.Fill;
        }
    }
}