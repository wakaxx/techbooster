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

namespace DeviceInfoApp
{
    public partial class MainPage : PhoneApplicationPage
    {
        // コンストラクター
        public MainPage()
        {
            InitializeComponent();
            listBox1.Items.Add("アプリのメモリ使用量: " + Microsoft.Phone.Info.DeviceStatus.ApplicationCurrentMemoryUsage);
            listBox1.Items.Add("アプリの割り当てメモリの最大容量: " + Microsoft.Phone.Info.DeviceStatus.ApplicationMemoryUsageLimit);
            listBox1.Items.Add("アプリの最大メモリ使用量: " + Microsoft.Phone.Info.DeviceStatus.ApplicationPeakMemoryUsage);
            listBox1.Items.Add("デバイスのハードウェアバージョン: " + Microsoft.Phone.Info.DeviceStatus.DeviceFirmwareVersion);
            listBox1.Items.Add("デバイスのファームウェアバージョン: " + Microsoft.Phone.Info.DeviceStatus.DeviceHardwareVersion);
            listBox1.Items.Add("デバイスの製造元: " + Microsoft.Phone.Info.DeviceStatus.DeviceManufacturer);
            listBox1.Items.Add("デバイス名: " + Microsoft.Phone.Info.DeviceStatus.DeviceName);
            listBox1.Items.Add("デバイスの物理RAMサイズ: " + Microsoft.Phone.Info.DeviceStatus.DeviceTotalMemory);
            listBox1.Items.Add("ハードウェアキーボードの有無: " + Microsoft.Phone.Info.DeviceStatus.IsKeyboardPresent);
            listBox1.Items.Add("ハードウェアキーボードを開閉: " + Microsoft.Phone.Info.DeviceStatus.IsKeyboardDeployed);
            listBox1.Items.Add("電源供給の種類: " + Microsoft.Phone.Info.DeviceStatus.PowerSource);
        }
    }
}