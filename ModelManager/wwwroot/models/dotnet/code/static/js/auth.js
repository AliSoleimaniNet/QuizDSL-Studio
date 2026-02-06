document.addEventListener('DOMContentLoaded', async () => {
  // انتخاب المان‌ها با یک ساختار تمیز
  const ui = {
    guest: document.getElementById('auth-guest'),
    user: document.getElementById('auth-user'),
    admin: document.getElementById('nav-admin-link'),
    name: document.getElementById('user-name-display'),
    userBtn: document.getElementById('user-menu-btn'),
    dropdown: document.getElementById('user-dropdown'),
    logoutBtn: document.getElementById('logout-btn')
  };

  // 1. استعلام وضعیت واقعی از سرور
  try {
    const response = await fetch('/api/auth-status');
    const status = await response.json();

    if (status.logged_in) {
      // کاربر لاگین است
      ui.guest?.classList.add('hidden');
      ui.user?.classList.remove('hidden');
      if (ui.name) ui.name.textContent = status.full_name || status.username;
      
      // نمایش لینک ادمین فقط برای نقش ادمین
      if (status.role === 'admin') {
        ui.admin?.classList.remove('hidden');
      }
    } else {
      // کاربر مهمان است
      ui.guest?.classList.remove('hidden');
      ui.user?.classList.add('hidden');
      ui.admin?.classList.add('hidden');
    }
  } catch (err) {
    console.error('Auth Check Failed:', err);
  }

  // 2. منطق باز و بسته شدن دراپ‌دان پروفایل
  if (ui.userBtn && ui.dropdown) {
    ui.userBtn.addEventListener('click', (e) => {
      e.stopPropagation();
      ui.dropdown.classList.toggle('hidden');
      ui.dropdown.classList.add('animate-fade-in');
    });

    // بستن دراپ‌دان با کلیک روی هر جای صفحه
    document.addEventListener('click', (e) => {
      if (!ui.userBtn.contains(e.target) && !ui.dropdown.contains(e.target)) {
        ui.dropdown.classList.add('hidden');
      }
    });
  }

  // 3. خروج از سیستم
  if (ui.logoutBtn) {
    ui.logoutBtn.addEventListener('click', () => {
      // هدایت به مسیر خروج فلاسک برای پاک کردن Session
      window.location.href = '/logout';
    });
  }
});