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
using Microsoft.Phone.Shell;

namespace ApplicationBarSample
{
    public partial class MainPage : PhoneApplicationPage
    {
        // コンストラクター
        public MainPage()
        {
            InitializeComponent();
        }

        private void OK_button_Click(object sender, EventArgs e)
        {
            textBlock1.Text = "Ok button clicked";
        }

        private void Cancel_button_Click(object sender, EventArgs e)
        {
            textBlock1.Text = "Cancel button clicked";
        }


        private void ApplicationBarMenuItem_Click_1(object sender, EventArgs e)
        {
            textBlock1.Text = "MenuItem1 Clicked";

        }

        private void ApplicationBarMenuItem_Click_2(object sender, EventArgs e)
        {
            textBlock1.Text = "MenuItem2 Clicked";

        }

        private void checkBox1_Click(object sender, RoutedEventArgs e)
        {
            CheckBox check = (CheckBox)sender;
            ApplicationBarIconButton appBarIcon = this.ApplicationBar.Buttons[0] as ApplicationBarIconButton;

            if ((bool)check.IsChecked)
            {
                appBarIcon.IsEnabled = false;
            }
            else
            {
                appBarIcon.IsEnabled = true;
            }

        }
    }
}