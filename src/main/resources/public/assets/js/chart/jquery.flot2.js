(function (e) {
    e.color = {};
    e.color.make = function (t, n, r, i) {
        var s = {};
        s.r = t || 0;
        s.g = n || 0;
        s.b = r || 0;
        s.a = i != null ? i : 1;
        s.add = function (e, t) {
            for (var n = 0; n < e.length; ++n) {
                s[e.charAt(n)] += t
            }
            return s.normalize()
        };
        s.scale = function (e, t) {
            for (var n = 0; n < e.length; ++n) {
                s[e.charAt(n)] *= t
            }
            return s.normalize()
        };
        s.toString = function () {
            if (s.a >= 1) {
                return "rgb(" + [s.r, s.g, s.b].join(",") + ")"
            } else {
                return "rgba(" + [s.r, s.g, s.b, s.a].join(",") + ")"
            }
        };
        s.normalize = function () {
            function e(e, t, n) {
                return t < e ? e : t > n ? n : t
            }

            s.r = e(0, parseInt(s.r), 255);
            s.g = e(0, parseInt(s.g), 255);
            s.b = e(0, parseInt(s.b), 255);
            s.a = e(0, s.a, 1);
            return s
        };
        s.clone = function () {
            return e.color.make(s.r, s.b, s.g, s.a)
        };
        return s.normalize()
    };
    e.color.extract = function (t, n) {
        var r;
        do {
            r = t.css(n).toLowerCase();
            if (r != "" && r != "transparent") {
                break
            }
            t = t.parent()
        } while (!e.nodeName(t.get(0), "body"));
        if (r == "rgba(0, 0, 0, 0)") {
            r = "transparent"
        }
        return e.color.parse(r)
    };
    e.color.parse = function (n) {
        var r, i = e.color.make;
        if (r = /rgb\(\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*\)/.exec(n)) {
            return i(parseInt(r[1], 10), parseInt(r[2], 10), parseInt(r[3], 10))
        }
        if (r = /rgba\(\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9]+(?:\.[0-9]+)?)\s*\)/.exec(n)) {
            return i(parseInt(r[1], 10), parseInt(r[2], 10), parseInt(r[3], 10), parseFloat(r[4]))
        }
        if (r = /rgb\(\s*([0-9]+(?:\.[0-9]+)?)\%\s*,\s*([0-9]+(?:\.[0-9]+)?)\%\s*,\s*([0-9]+(?:\.[0-9]+)?)\%\s*\)/.exec(n)) {
            return i(parseFloat(r[1]) * 2.55, parseFloat(r[2]) * 2.55, parseFloat(r[3]) * 2.55)
        }
        if (r = /rgba\(\s*([0-9]+(?:\.[0-9]+)?)\%\s*,\s*([0-9]+(?:\.[0-9]+)?)\%\s*,\s*([0-9]+(?:\.[0-9]+)?)\%\s*,\s*([0-9]+(?:\.[0-9]+)?)\s*\)/.exec(n)) {
            return i(parseFloat(r[1]) * 2.55, parseFloat(r[2]) * 2.55, parseFloat(r[3]) * 2.55, parseFloat(r[4]))
        }
        if (r = /#([a-fA-F0-9]{2})([a-fA-F0-9]{2})([a-fA-F0-9]{2})/.exec(n)) {
            return i(parseInt(r[1], 16), parseInt(r[2], 16), parseInt(r[3], 16))
        }
        if (r = /#([a-fA-F0-9])([a-fA-F0-9])([a-fA-F0-9])/.exec(n)) {
            return i(parseInt(r[1] + r[1], 16), parseInt(r[2] + r[2], 16), parseInt(r[3] + r[3], 16))
        }
        var s = e.trim(n).toLowerCase();
        if (s == "transparent") {
            return i(255, 255, 255, 0)
        } else {
            r = t[s] || [0, 0, 0];
            return i(r[0], r[1], r[2])
        }
    };
    var t = {
        aqua: [0, 255, 255],
        azure: [240, 255, 255],
        beige: [245, 245, 220],
        black: [0, 0, 0],
        blue: [0, 0, 255],
        brown: [165, 42, 42],
        cyan: [0, 255, 255],
        darkblue: [0, 0, 139],
        darkcyan: [0, 139, 139],
        darkgrey: [169, 169, 169],
        darkgreen: [0, 100, 0],
        darkkhaki: [189, 183, 107],
        darkmagenta: [139, 0, 139],
        darkolivegreen: [85, 107, 47],
        darkorange: [255, 140, 0],
        darkorchid: [153, 50, 204],
        darkred: [139, 0, 0],
        darksalmon: [233, 150, 122],
        darkviolet: [148, 0, 211],
        fuchsia: [255, 0, 255],
        gold: [255, 215, 0],
        green: [0, 128, 0],
        indigo: [75, 0, 130],
        khaki: [240, 230, 140],
        lightblue: [173, 216, 230],
        lightcyan: [224, 255, 255],
        lightgreen: [144, 238, 144],
        lightgrey: [211, 211, 211],
        lightpink: [255, 182, 193],
        lightyellow: [255, 255, 224],
        lime: [0, 255, 0],
        magenta: [255, 0, 255],
        maroon: [128, 0, 0],
        navy: [0, 0, 128],
        olive: [128, 128, 0],
        orange: [255, 165, 0],
        pink: [255, 192, 203],
        purple: [128, 0, 128],
        violet: [128, 0, 128],
        red: [255, 0, 0],
        silver: [192, 192, 192],
        white: [255, 255, 255],
        yellow: [255, 255, 0]
    }
})(jQuery);
(function (e) {
    function t(t, r, s, o) {
        function x(e, t) {
            t = [S].concat(t);
            for (var n = 0; n < e.length; ++n)e[n].apply(this, t)
        }

        function T() {
            for (var t = 0; t < o.length; ++t) {
                var n = o[t];
                n.init(S);
                if (n.options)e.extend(true, a, n.options)
            }
        }

        function N(t) {
            var n;
            e.extend(true, a, t);
            if (a.xaxis.color == null)a.xaxis.color = a.grid.color;
            if (a.yaxis.color == null)a.yaxis.color = a.grid.color;
            if (a.xaxis.tickColor == null)a.xaxis.tickColor = a.grid.tickColor;
            if (a.yaxis.tickColor == null)a.yaxis.tickColor = a.grid.tickColor;
            if (a.grid.borderColor == null)a.grid.borderColor = a.grid.color;
            if (a.grid.tickColor == null)a.grid.tickColor = e.color.parse(a.grid.color).scale("a", .22).toString();
            for (n = 0; n < Math.max(1, a.xaxes.length); ++n)a.xaxes[n] = e.extend(true, {}, a.xaxis, a.xaxes[n]);
            for (n = 0; n < Math.max(1, a.yaxes.length); ++n)a.yaxes[n] = e.extend(true, {}, a.yaxis, a.yaxes[n]);
            if (a.xaxis.noTicks && a.xaxis.ticks == null)a.xaxis.ticks = a.xaxis.noTicks;
            if (a.yaxis.noTicks && a.yaxis.ticks == null)a.yaxis.ticks = a.yaxis.noTicks;
            if (a.x2axis) {
                a.xaxes[1] = e.extend(true, {}, a.xaxis, a.x2axis);
                a.xaxes[1].position = "top"
            }
            if (a.y2axis) {
                a.yaxes[1] = e.extend(true, {}, a.yaxis, a.y2axis);
                a.yaxes[1].position = "right"
            }
            if (a.grid.coloredAreas)a.grid.markings = a.grid.coloredAreas;
            if (a.grid.coloredAreasColor)a.grid.markingsColor = a.grid.coloredAreasColor;
            if (a.lines)e.extend(true, a.series.lines, a.lines);
            if (a.points)e.extend(true, a.series.points, a.points);
            if (a.bars)e.extend(true, a.series.bars, a.bars);
            if (a.shadowSize != null)a.series.shadowSize = a.shadowSize;
            for (n = 0; n < a.xaxes.length; ++n)_(d, n + 1).options = a.xaxes[n];
            for (n = 0; n < a.yaxes.length; ++n)_(v, n + 1).options = a.yaxes[n];
            for (var r in E)if (a.hooks[r] && a.hooks[r].length)E[r] = E[r].concat(a.hooks[r]);
            x(E.processOptions, [a])
        }

        function C(e) {
            u = k(e);
            D();
            P()
        }

        function k(t) {
            var n = [];
            for (var r = 0; r < t.length; ++r) {
                var i = e.extend(true, {}, a.series);
                if (t[r].data != null) {
                    i.data = t[r].data;
                    delete t[r].data;
                    e.extend(true, i, t[r]);
                    t[r].data = i.data
                } else i.data = t[r];
                n.push(i)
            }
            return n
        }

        function L(e, t) {
            var n = e[t + "axis"];
            if (typeof n == "object")n = n.n;
            if (typeof n != "number")n = 1;
            return n
        }

        function A() {
            return e.grep(d.concat(v), function (e) {
                return e
            })
        }

        function O(e) {
            var t = {}, n, r;
            for (n = 0; n < d.length; ++n) {
                r = d[n];
                if (r && r.used)t["x" + r.n] = r.c2p(e.left)
            }
            for (n = 0; n < v.length; ++n) {
                r = v[n];
                if (r && r.used)t["y" + r.n] = r.c2p(e.top)
            }
            if (t.x1 !== undefined)t.x = t.x1;
            if (t.y1 !== undefined)t.y = t.y1;
            return t
        }

        function M(e) {
            var t = {}, n, r, i;
            for (n = 0; n < d.length; ++n) {
                r = d[n];
                if (r && r.used) {
                    i = "x" + r.n;
                    if (e[i] == null && r.n == 1)i = "x";
                    if (e[i] != null) {
                        t.left = r.p2c(e[i]);
                        break
                    }
                }
            }
            for (n = 0; n < v.length; ++n) {
                r = v[n];
                if (r && r.used) {
                    i = "y" + r.n;
                    if (e[i] == null && r.n == 1)i = "y";
                    if (e[i] != null) {
                        t.top = r.p2c(e[i]);
                        break
                    }
                }
            }
            return t
        }

        function _(t, n) {
            if (!t[n - 1])t[n - 1] = {
                n: n,
                direction: t == d ? "x" : "y",
                options: e.extend(true, {}, t == d ? a.xaxis : a.yaxis)
            };
            return t[n - 1]
        }

        function D() {
            var t;
            var n = u.length, r = [], i = [];
            for (t = 0; t < u.length; ++t) {
                var s = u[t].color;
                if (s != null) {
                    --n;
                    if (typeof s == "number")i.push(s); else r.push(e.color.parse(u[t].color))
                }
            }
            for (t = 0; t < i.length; ++t) {
                n = Math.max(n, i[t] + 1)
            }
            var o = [], f = 0;
            t = 0;
            while (o.length < n) {
                var l;
                if (a.colors.length == t)l = e.color.make(100, 100, 100); else l = e.color.parse(a.colors[t]);
                var c = f % 2 == 1 ? -1 : 1;
                l.scale("rgb", 1 + c * Math.ceil(f / 2) * .2);
                o.push(l);
                ++t;
                if (t >= a.colors.length) {
                    t = 0;
                    ++f
                }
            }
            var h = 0, p;
            for (t = 0; t < u.length; ++t) {
                p = u[t];
                if (p.color == null) {
                    p.color = o[h].toString();
                    ++h
                } else if (typeof p.color == "number")p.color = o[p.color].toString();
                if (p.lines.show == null) {
                    var m, g = true;
                    for (m in p)if (p[m] && p[m].show) {
                        g = false;
                        break
                    }
                    if (g)p.lines.show = true
                }
                p.xaxis = _(d, L(p, "x"));
                p.yaxis = _(v, L(p, "y"))
            }
        }

        function P() {
            function b(e, t, n) {
                if (t < e.datamin && t != -r)e.datamin = t;
                if (n > e.datamax && n != r)e.datamax = n
            }

            var t = Number.POSITIVE_INFINITY, n = Number.NEGATIVE_INFINITY, r = Number.MAX_VALUE, i, s, o, a, f, l, c, h, p, d, v, m, g, y;
            e.each(A(), function (e, r) {
                r.datamin = t;
                r.datamax = n;
                r.used = false
            });
            for (i = 0; i < u.length; ++i) {
                l = u[i];
                l.datapoints = {points: []};
                x(E.processRawData, [l, l.data, l.datapoints])
            }
            for (i = 0; i < u.length; ++i) {
                l = u[i];
                var w = l.data, S = l.datapoints.format;
                if (!S) {
                    S = [];
                    S.push({x: true, number: true, required: true});
                    S.push({y: true, number: true, required: true});
                    if (l.bars.show || l.lines.show && l.lines.fill) {
                        S.push({y: true, number: true, required: false, defaultValue: 0});
                        if (l.bars.horizontal) {
                            delete S[S.length - 1].y;
                            S[S.length - 1].x = true
                        }
                    }
                    l.datapoints.format = S
                }
                if (l.datapoints.pointsize != null)continue;
                l.datapoints.pointsize = S.length;
                h = l.datapoints.pointsize;
                c = l.datapoints.points;
                insertSteps = l.lines.show && l.lines.steps;
                l.xaxis.used = l.yaxis.used = true;
                for (s = o = 0; s < w.length; ++s, o += h) {
                    y = w[s];
                    var T = y == null;
                    if (!T) {
                        for (a = 0; a < h; ++a) {
                            m = y[a];
                            g = S[a];
                            if (g) {
                                if (g.number && m != null) {
                                    m = +m;
                                    if (isNaN(m))m = null; else if (m == Infinity)m = r; else if (m == -Infinity)m = -r
                                }
                                if (m == null) {
                                    if (g.required)T = true;
                                    if (g.defaultValue != null)m = g.defaultValue
                                }
                            }
                            c[o + a] = m
                        }
                    }
                    if (T) {
                        for (a = 0; a < h; ++a) {
                            m = c[o + a];
                            if (m != null) {
                                g = S[a];
                                if (g.x)b(l.xaxis, m, m);
                                if (g.y)b(l.yaxis, m, m)
                            }
                            c[o + a] = null
                        }
                    } else {
                        if (insertSteps && o > 0 && c[o - h] != null && c[o - h] != c[o] && c[o - h + 1] != c[o + 1]) {
                            for (a = 0; a < h; ++a)c[o + h + a] = c[o + a];
                            c[o + 1] = c[o - h + 1];
                            o += h
                        }
                    }
                }
            }
            for (i = 0; i < u.length; ++i) {
                l = u[i];
                x(E.processDatapoints, [l, l.datapoints])
            }
            for (i = 0; i < u.length; ++i) {
                l = u[i];
                c = l.datapoints.points, h = l.datapoints.pointsize;
                var N = t, C = t, k = n, L = n;
                for (s = 0; s < c.length; s += h) {
                    if (c[s] == null)continue;
                    for (a = 0; a < h; ++a) {
                        m = c[s + a];
                        g = S[a];
                        if (!g || m == r || m == -r)continue;
                        if (g.x) {
                            if (m < N)N = m;
                            if (m > k)k = m
                        }
                        if (g.y) {
                            if (m < C)C = m;
                            if (m > L)L = m
                        }
                    }
                }
                if (l.bars.show) {
                    var O = l.bars.align == "left" ? 0 : -l.bars.barWidth / 2;
                    if (l.bars.horizontal) {
                        C += O;
                        L += O + l.bars.barWidth
                    } else {
                        N += O;
                        k += O + l.bars.barWidth
                    }
                }
                b(l.xaxis, N, k);
                b(l.yaxis, C, L)
            }
            e.each(A(), function (e, r) {
                if (r.datamin == t)r.datamin = null;
                if (r.datamax == n)r.datamax = null
            })
        }

        function H(n, r) {
            var i = document.createElement("canvas");
            i.className = r;
            i.width = g;
            i.height = y;
            if (!n)e(i).css({position: "absolute", left: 0, top: 0});
            e(i).appendTo(t);
            if (!i.getContext)i = window.G_vmlCanvasManager.initElement(i);
            i.getContext("2d").save();
            return i
        }

        function B() {
            g = t.width();
            y = t.height();
            if (g <= 0 || y <= 0)throw"Invalid dimensions for plot, width = " + g + ", height = " + y
        }

        function j(e) {
            if (e.width != g)e.width = g;
            if (e.height != y)e.height = y;
            var t = e.getContext("2d");
            t.restore();
            t.save()
        }

        function F() {
            var n, r = t.children("canvas.base"), i = t.children("canvas.overlay");
            if (r.length == 0 || i == 0) {
                t.html("");
                t.css({padding: 0});
                if (t.css("position") == "static")t.css("position", "relative");
                B();
                f = H(true, "base");
                l = H(false, "overlay");
                n = false
            } else {
                f = r.get(0);
                l = i.get(0);
                n = true
            }
            h = f.getContext("2d");
            p = l.getContext("2d");
            c = e([l, f]);
            if (n) {
                t.data("plot").shutdown();
                S.resize();
                p.clearRect(0, 0, g, y);
                c.unbind();
                t.children().not([f, l]).remove()
            }
            t.data("plot", S)
        }

        function I() {
            if (a.grid.hoverable) {
                c.mousemove(ht);
                c.mouseleave(pt)
            }
            if (a.grid.clickable)c.click(dt);
            x(E.bindEvents, [c])
        }

        function q() {
            if (lt)clearTimeout(lt);
            c.unbind("mousemove", ht);
            c.unbind("mouseleave", pt);
            c.unbind("click", dt);
            x(E.shutdown, [c])
        }

        function R(e) {
            function t(e) {
                return e
            }

            var n, r, i = e.options.transform || t, s = e.options.inverseTransform;
            if (e.direction == "x") {
                n = e.scale = b / Math.abs(i(e.max) - i(e.min));
                r = Math.min(i(e.max), i(e.min))
            } else {
                n = e.scale = w / Math.abs(i(e.max) - i(e.min));
                n = -n;
                r = Math.max(i(e.max), i(e.min))
            }
            if (i == t)e.p2c = function (e) {
                return (e - r) * n
            }; else e.p2c = function (e) {
                return (i(e) - r) * n
            };
            if (!s)e.c2p = function (e) {
                return r + e / n
            }; else e.c2p = function (e) {
                return s(r + e / n)
            }
        }

        function U(n) {
            function c(r, i) {
                return e('<div style="position:absolute;top:-10000px;' + i + 'font-size:smaller">' + '<div class="' + n.direction + "Axis " + n.direction + n.n + 'Axis">' + r.join("") + "</div></div>").appendTo(t)
            }

            var r = n.options, i, s = n.ticks || [], o = [], u, a = r.labelWidth, f = r.labelHeight, l;
            if (n.direction == "x") {
                if (a == null)a = Math.floor(g / (s.length > 0 ? s.length : 1));
                if (f == null) {
                    o = [];
                    for (i = 0; i < s.length; ++i) {
                        u = s[i].label;
                        if (u)o.push('<div class="tickLabel" style="float:left;width:' + a + 'px">' + u + "</div>")
                    }
                    if (o.length > 0) {
                        o.push('<div style="clear:left"></div>');
                        l = c(o, "width:10000px;");
                        f = l.height();
                        l.remove()
                    }
                }
            } else if (a == null || f == null) {
                for (i = 0; i < s.length; ++i) {
                    u = s[i].label;
                    if (u)o.push('<div class="tickLabel">' + u + "</div>")
                }
                if (o.length > 0) {
                    l = c(o, "");
                    if (a == null)a = l.children().width();
                    if (f == null)f = l.find("div.tickLabel").height();
                    l.remove()
                }
            }
            if (a == null)a = 0;
            if (f == null)f = 0;
            n.labelWidth = a;
            n.labelHeight = f
        }

        function z(t) {
            var n = t.labelWidth, r = t.labelHeight, i = t.options.position, s = t.options.tickLength, o = a.grid.axisMargin, u = a.grid.labelMargin, f = t.direction == "x" ? d : v, l;
            var c = e.grep(f, function (e) {
                return e && e.options.position == i && e.reserveSpace
            });
            if (e.inArray(t, c) == c.length - 1)o = 0;
            if (s == null)s = "full";
            var h = e.grep(f, function (e) {
                return e && e.reserveSpace
            });
            var p = e.inArray(t, h) == 0;
            if (!p && s == "full")s = 5;
            if (!isNaN(+s))u += +s;
            if (t.direction == "x") {
                r += u;
                if (i == "bottom") {
                    m.bottom += r + o;
                    t.box = {top: y - m.bottom, height: r}
                } else {
                    t.box = {top: m.top + o, height: r};
                    m.top += r + o
                }
            } else {
                n += u;
                if (i == "left") {
                    t.box = {left: m.left + o, width: n};
                    m.left += n + o
                } else {
                    m.right += n + o;
                    t.box = {left: g - m.right, width: n}
                }
            }
            t.position = i;
            t.tickLength = s;
            t.box.padding = u;
            t.innermost = p
        }

        function W(e) {
            if (e.direction == "x") {
                e.box.left = m.left;
                e.box.width = b
            } else {
                e.box.top = m.top;
                e.box.height = w
            }
        }

        function X() {
            var t, n = A();
            e.each(n, function (e, t) {
                t.show = t.options.show;
                if (t.show == null)t.show = t.used;
                t.reserveSpace = t.show || t.options.reserveSpace;
                V(t)
            });
            allocatedAxes = e.grep(n, function (e) {
                return e.reserveSpace
            });
            m.left = m.right = m.top = m.bottom = 0;
            if (a.grid.show) {
                e.each(allocatedAxes, function (e, t) {
                    J(t);
                    K(t);
                    Q(t, t.ticks);
                    U(t)
                });
                for (t = allocatedAxes.length - 1; t >= 0; --t)z(allocatedAxes[t]);
                var r = a.grid.minBorderMargin;
                if (r == null) {
                    r = 0;
                    for (t = 0; t < u.length; ++t)r = Math.max(r, u[t].points.radius + u[t].points.lineWidth / 2)
                }
                for (var i in m) {
                    m[i] += a.grid.borderWidth;
                    m[i] = Math.max(r, m[i])
                }
            }
            b = g - m.left - m.right;
            w = y - m.bottom - m.top;
            e.each(n, function (e, t) {
                R(t)
            });
            if (a.grid.show) {
                e.each(allocatedAxes, function (e, t) {
                    W(t)
                });
                tt()
            }
            at()
        }

        function V(e) {
            var t = e.options, n = +(t.min != null ? t.min : e.datamin), r = +(t.max != null ? t.max : e.datamax), i = r - n;
            if (i == 0) {
                var s = r == 0 ? 1 : .01;
                if (t.min == null)n -= s;
                if (t.max == null || t.min != null)r += s
            } else {
                var o = t.autoscaleMargin;
                if (o != null) {
                    if (t.min == null) {
                        n -= i * o;
                        if (n < 0 && e.datamin != null && e.datamin >= 0)n = 0
                    }
                    if (t.max == null) {
                        r += i * o;
                        if (r > 0 && e.datamax != null && e.datamax <= 0)r = 0
                    }
                }
            }
            e.min = n;
            e.max = r
        }

        function J(t) {
            var r = t.options;
            var i;
            if (typeof r.ticks == "number" && r.ticks > 0)i = r.ticks; else i = .3 * Math.sqrt(t.direction == "x" ? g : y);
            var s = (t.max - t.min) / i, o, u, a, f, l, c, h;
            if (r.mode == "time") {
                var p = {
                    second: 1e3,
                    minute: 60 * 1e3,
                    hour: 60 * 60 * 1e3,
                    day: 24 * 60 * 60 * 1e3,
                    month: 30 * 24 * 60 * 60 * 1e3,
                    year: 365.2425 * 24 * 60 * 60 * 1e3
                };
                var m = [[1, "second"], [2, "second"], [5, "second"], [10, "second"], [30, "second"], [1, "minute"], [2, "minute"], [5, "minute"], [10, "minute"], [30, "minute"], [1, "hour"], [2, "hour"], [4, "hour"], [8, "hour"], [12, "hour"], [1, "day"], [2, "day"], [3, "day"], [.25, "month"], [.5, "month"], [1, "month"], [2, "month"], [3, "month"], [6, "month"], [1, "year"]];
                var b = 0;
                if (r.minTickSize != null) {
                    if (typeof r.tickSize == "number")b = r.tickSize; else b = r.minTickSize[0] * p[r.minTickSize[1]]
                }
                for (var l = 0; l < m.length - 1; ++l)if (s < (m[l][0] * p[m[l][1]] + m[l + 1][0] * p[m[l + 1][1]]) / 2 && m[l][0] * p[m[l][1]] >= b)break;
                o = m[l][0];
                a = m[l][1];
                if (a == "year") {
                    c = Math.pow(10, Math.floor(Math.log(s / p.year) / Math.LN10));
                    h = s / p.year / c;
                    if (h < 1.5)o = 1; else if (h < 3)o = 2; else if (h < 7.5)o = 5; else o = 10;
                    o *= c
                }
                t.tickSize = r.tickSize || [o, a];
                u = function (e) {
                    var t = [], r = e.tickSize[0], i = e.tickSize[1], s = new Date(e.min);
                    var o = r * p[i];
                    if (i == "second")s.setUTCSeconds(n(s.getUTCSeconds(), r));
                    if (i == "minute")s.setUTCMinutes(n(s.getUTCMinutes(), r));
                    if (i == "hour")s.setUTCHours(n(s.getUTCHours(), r));
                    if (i == "month")s.setUTCMonth(n(s.getUTCMonth(), r));
                    if (i == "year")s.setUTCFullYear(n(s.getUTCFullYear(), r));
                    s.setUTCMilliseconds(0);
                    if (o >= p.minute)s.setUTCSeconds(0);
                    if (o >= p.hour)s.setUTCMinutes(0);
                    if (o >= p.day)s.setUTCHours(0);
                    if (o >= p.day * 4)s.setUTCDate(1);
                    if (o >= p.year)s.setUTCMonth(0);
                    var u = 0, a = Number.NaN, f;
                    do {
                        f = a;
                        a = s.getTime();
                        t.push(a);
                        if (i == "month") {
                            if (r < 1) {
                                s.setUTCDate(1);
                                var l = s.getTime();
                                s.setUTCMonth(s.getUTCMonth() + 1);
                                var c = s.getTime();
                                s.setTime(a + u * p.hour + (c - l) * r);
                                u = s.getUTCHours();
                                s.setUTCHours(0)
                            } else s.setUTCMonth(s.getUTCMonth() + r)
                        } else if (i == "year") {
                            s.setUTCFullYear(s.getUTCFullYear() + r)
                        } else s.setTime(a + o)
                    } while (a < e.max && a != f);
                    return t
                };
                f = function (t, n) {
                    var i = new Date(t);
                    if (r.timeformat != null)return e.plot.formatDate(i, r.timeformat, r.monthNames);
                    var s = n.tickSize[0] * p[n.tickSize[1]];
                    var o = n.max - n.min;
                    var u = r.twelveHourClock ? " %p" : "";
                    if (s < p.minute)fmt = "%h:%M:%S" + u; else if (s < p.day) {
                        if (o < 2 * p.day)fmt = "%h:%M" + u; else fmt = "%b %d %h:%M" + u
                    } else if (s < p.month)fmt = "%b %d"; else if (s < p.year) {
                        if (o < p.year)fmt = "%b"; else fmt = "%b %y"
                    } else fmt = "%y";
                    return e.plot.formatDate(i, fmt, r.monthNames)
                }
            } else {
                var w = r.tickDecimals;
                var E = -Math.floor(Math.log(s) / Math.LN10);
                if (w != null && E > w)E = w;
                c = Math.pow(10, -E);
                h = s / c;
                if (h < 1.5)o = 1; else if (h < 3) {
                    o = 2;
                    if (h > 2.25 && (w == null || E + 1 <= w)) {
                        o = 2.5;
                        ++E
                    }
                } else if (h < 7.5)o = 5; else o = 10;
                o *= c;
                if (r.minTickSize != null && o < r.minTickSize)o = r.minTickSize;
                t.tickDecimals = Math.max(0, w != null ? w : E);
                t.tickSize = r.tickSize || o;
                u = function (e) {
                    var t = [];
                    var r = n(e.min, e.tickSize), i = 0, s = Number.NaN, o;
                    do {
                        o = s;
                        s = r + i * e.tickSize;
                        t.push(s);
                        ++i
                    } while (s < e.max && s != o);
                    return t
                };
                f = function (e, t) {
                    return e.toFixed(t.tickDecimals)
                }
            }
            if (r.alignTicksWithAxis != null) {
                var S = (t.direction == "x" ? d : v)[r.alignTicksWithAxis - 1];
                if (S && S.used && S != t) {
                    var x = u(t);
                    if (x.length > 0) {
                        if (r.min == null)t.min = Math.min(t.min, x[0]);
                        if (r.max == null && x.length > 1)t.max = Math.max(t.max, x[x.length - 1])
                    }
                    u = function (e) {
                        var t = [], n, r;
                        for (r = 0; r < S.ticks.length; ++r) {
                            n = (S.ticks[r].v - S.min) / (S.max - S.min);
                            n = e.min + n * (e.max - e.min);
                            t.push(n)
                        }
                        return t
                    };
                    if (t.mode != "time" && r.tickDecimals == null) {
                        var T = Math.max(0, -Math.floor(Math.log(s) / Math.LN10) + 1), N = u(t);
                        if (!(N.length > 1 && /\..*0$/.test((N[1] - N[0]).toFixed(T))))t.tickDecimals = T
                    }
                }
            }
            t.tickGenerator = u;
            if (e.isFunction(r.tickFormatter))t.tickFormatter = function (e, t) {
                return "" + r.tickFormatter(e, t)
            }; else t.tickFormatter = f
        }

        function K(t) {
            var n = t.options.ticks, r = [];
            if (n == null || typeof n == "number" && n > 0)r = t.tickGenerator(t); else if (n) {
                if (e.isFunction(n))r = n({min: t.min, max: t.max}); else r = n
            }
            var i, s;
            t.ticks = [];
            for (i = 0; i < r.length; ++i) {
                var o = null;
                var u = r[i];
                if (typeof u == "object") {
                    s = +u[0];
                    if (u.length > 1)o = u[1]
                } else s = +u;
                if (o == null)o = t.tickFormatter(s, t);
                if (!isNaN(s))t.ticks.push({v: s, label: o})
            }
        }

        function Q(e, t) {
            if (e.options.autoscaleMargin && t.length > 0) {
                if (e.options.min == null)e.min = Math.min(e.min, t[0].v);
                if (e.options.max == null && t.length > 1)e.max = Math.max(e.max, t[t.length - 1].v)
            }
        }

        function G() {
            h.clearRect(0, 0, g, y);
            var e = a.grid;
            if (e.show && e.backgroundColor)Z();
            if (e.show && !e.aboveData)et();
            for (var t = 0; t < u.length; ++t) {
                x(E.drawSeries, [h, u[t]]);
                nt(u[t])
            }
            x(E.draw, [h]);
            if (e.show && e.aboveData)et()
        }

        function Y(e, t) {
            var n, r, s, o, u = A();
            for (i = 0; i < u.length; ++i) {
                n = u[i];
                if (n.direction == t) {
                    o = t + n.n + "axis";
                    if (!e[o] && n.n == 1)o = t + "axis";
                    if (e[o]) {
                        r = e[o].from;
                        s = e[o].to;
                        break
                    }
                }
            }
            if (!e[o]) {
                n = t == "x" ? d[0] : v[0];
                r = e[t + "1"];
                s = e[t + "2"]
            }
            if (r != null && s != null && r > s) {
                var a = r;
                r = s;
                s = a
            }
            return {from: r, to: s, axis: n}
        }

        function Z() {
            h.save();
            h.translate(m.left, m.top);
            h.fillStyle = xt(a.grid.backgroundColor, w, 0, "rgba(255, 255, 255, 0)");
            h.fillRect(0, 0, b, w);
            h.restore()
        }

        function et() {
            var t;
            h.save();
            h.translate(m.left, m.top);
            var n = a.grid.markings;
            if (n) {
                if (e.isFunction(n)) {
                    var r = S.getAxes();
                    r.xmin = r.xaxis.min;
                    r.xmax = r.xaxis.max;
                    r.ymin = r.yaxis.min;
                    r.ymax = r.yaxis.max;
                    n = n(r)
                }
                for (t = 0; t < n.length; ++t) {
                    var i = n[t], s = Y(i, "x"), o = Y(i, "y");
                    if (s.from == null)s.from = s.axis.min;
                    if (s.to == null)s.to = s.axis.max;
                    if (o.from == null)o.from = o.axis.min;
                    if (o.to == null)o.to = o.axis.max;
                    if (s.to < s.axis.min || s.from > s.axis.max || o.to < o.axis.min || o.from > o.axis.max)continue;
                    s.from = Math.max(s.from, s.axis.min);
                    s.to = Math.min(s.to, s.axis.max);
                    o.from = Math.max(o.from, o.axis.min);
                    o.to = Math.min(o.to, o.axis.max);
                    if (s.from == s.to && o.from == o.to)continue;
                    s.from = s.axis.p2c(s.from);
                    s.to = s.axis.p2c(s.to);
                    o.from = o.axis.p2c(o.from);
                    o.to = o.axis.p2c(o.to);
                    if (s.from == s.to || o.from == o.to) {
                        h.beginPath();
                        h.strokeStyle = i.color || a.grid.markingsColor;
                        h.lineWidth = i.lineWidth || a.grid.markingsLineWidth;
                        h.moveTo(s.from, o.from);
                        h.lineTo(s.to, o.to);
                        h.stroke()
                    } else {
                        h.fillStyle = i.color || a.grid.markingsColor;
                        h.fillRect(s.from, o.to, s.to - s.from, o.from - o.to)
                    }
                }
            }
            var r = A(), u = a.grid.borderWidth;
            for (var f = 0; f < r.length; ++f) {
                var l = r[f], c = l.box, p = l.tickLength, d, v, g, y;
                if (!l.show || l.ticks.length == 0)continue;
                h.strokeStyle = l.options.tickColor || e.color.parse(l.options.color).scale("a", .22).toString();
                h.lineWidth = 1;
                if (l.direction == "x") {
                    d = 0;
                    if (p == "full")v = l.position == "top" ? 0 : w; else v = c.top - m.top + (l.position == "top" ? c.height : 0)
                } else {
                    v = 0;
                    if (p == "full")d = l.position == "left" ? 0 : b; else d = c.left - m.left + (l.position == "left" ? c.width : 0)
                }
                if (!l.innermost) {
                    h.beginPath();
                    g = y = 0;
                    if (l.direction == "x")g = b; else y = w;
                    if (h.lineWidth == 1) {
                        d = Math.floor(d) + .5;
                        v = Math.floor(v) + .5
                    }
                    h.moveTo(d, v);
                    h.lineTo(d + g, v + y);
                    h.stroke()
                }
                h.beginPath();
                for (t = 0; t < l.ticks.length; ++t) {
                    var E = l.ticks[t].v;
                    g = y = 0;
                    if (E < l.min || E > l.max || p == "full" && u > 0 && (E == l.min || E == l.max))continue;
                    if (l.direction == "x") {
                        d = l.p2c(E);
                        y = p == "full" ? -w : p;
                        if (l.position == "top")y = -y
                    } else {
                        v = l.p2c(E);
                        g = p == "full" ? -b : p;
                        if (l.position == "left")g = -g
                    }
                    if (h.lineWidth == 1) {
                        if (l.direction == "x")d = Math.floor(d) + .5; else v = Math.floor(v) + .5
                    }
                    h.moveTo(d, v);
                    h.lineTo(d + g, v + y)
                }
                h.stroke()
            }
            if (u) {
                h.lineWidth = u;
                h.strokeStyle = a.grid.borderColor;
                h.strokeRect(-u / 2, -u / 2, b + u, w + u)
            }
            h.restore()
        }

        function tt() {
            t.find(".tickLabels").remove();
            var e = ['<div class="tickLabels" style="font-size:smaller">'];
            var n = A();
            for (var r = 0; r < n.length; ++r) {
                var i = n[r], s = i.box;
                if (!i.show)continue;
                e.push('<div class="' + i.direction + "Axis " + i.direction + i.n + 'Axis" style="color:' + i.options.color + '">');
                for (var o = 0; o < i.ticks.length; ++o) {
                    var u = i.ticks[o];
                    if (!u.label || u.v < i.min || u.v > i.max)continue;
                    var a = {}, f;
                    if (i.direction == "x") {
                        f = "center";
                        a.left = Math.round(m.left + i.p2c(u.v) - i.labelWidth / 2);
                        if (i.position == "bottom")a.top = s.top + s.padding; else a.bottom = y - (s.top + s.height - s.padding)
                    } else {
                        a.top = Math.round(m.top + i.p2c(u.v) - i.labelHeight / 2);
                        if (i.position == "left") {
                            a.right = g - (s.left + s.width - s.padding);
                            f = "right"
                        } else {
                            a.left = s.left + s.padding;
                            f = "left"
                        }
                    }
                    a.width = i.labelWidth;
                    var l = ["position:absolute", "text-align:" + f];
                    for (var c in a)l.push(c + ":" + a[c] + "px");
                    e.push('<div class="tickLabel" style="' + l.join(";") + '">' + u.label + "</div>")
                }
                e.push("</div>")
            }
            e.push("</div>");
            t.append(e.join(""))
        }

        function nt(e) {
            if (e.lines.show)rt(e);
            if (e.bars.show)ot(e);
            if (e.points.show)it(e)
        }

        function rt(e) {
            function t(e, t, n, r, i) {
                var s = e.points, o = e.pointsize, u = null, a = null;
                h.beginPath();
                for (var f = o; f < s.length; f += o) {
                    var l = s[f - o], c = s[f - o + 1], p = s[f], d = s[f + 1];
                    if (l == null || p == null)continue;
                    if (c <= d && c < i.min) {
                        if (d < i.min)continue;
                        l = (i.min - c) / (d - c) * (p - l) + l;
                        c = i.min
                    } else if (d <= c && d < i.min) {
                        if (c < i.min)continue;
                        p = (i.min - c) / (d - c) * (p - l) + l;
                        d = i.min
                    }
                    if (c >= d && c > i.max) {
                        if (d > i.max)continue;
                        l = (i.max - c) / (d - c) * (p - l) + l;
                        c = i.max
                    } else if (d >= c && d > i.max) {
                        if (c > i.max)continue;
                        p = (i.max - c) / (d - c) * (p - l) + l;
                        d = i.max
                    }
                    if (l <= p && l < r.min) {
                        if (p < r.min)continue;
                        c = (r.min - l) / (p - l) * (d - c) + c;
                        l = r.min
                    } else if (p <= l && p < r.min) {
                        if (l < r.min)continue;
                        d = (r.min - l) / (p - l) * (d - c) + c;
                        p = r.min
                    }
                    if (l >= p && l > r.max) {
                        if (p > r.max)continue;
                        c = (r.max - l) / (p - l) * (d - c) + c;
                        l = r.max
                    } else if (p >= l && p > r.max) {
                        if (l > r.max)continue;
                        d = (r.max - l) / (p - l) * (d - c) + c;
                        p = r.max
                    }
                    if (l != u || c != a)h.moveTo(r.p2c(l) + t, i.p2c(c) + n);
                    u = p;
                    a = d;
                    h.lineTo(r.p2c(p) + t, i.p2c(d) + n)
                }
                h.stroke()
            }

            function n(e, t, n) {
                var r = e.points, i = e.pointsize, s = Math.min(Math.max(0, n.min), n.max), o = 0, u, a = false, f = 1, l = 0, c = 0;
                while (true) {
                    if (i > 0 && o > r.length + i)break;
                    o += i;
                    var p = r[o - i], d = r[o - i + f], v = r[o], m = r[o + f];
                    if (a) {
                        if (i > 0 && p != null && v == null) {
                            c = o;
                            i = -i;
                            f = 2;
                            continue
                        }
                        if (i < 0 && o == l + i) {
                            h.fill();
                            a = false;
                            i = -i;
                            f = 1;
                            o = l = c + i;
                            continue
                        }
                    }
                    if (p == null || v == null)continue;
                    if (p <= v && p < t.min) {
                        if (v < t.min)continue;
                        d = (t.min - p) / (v - p) * (m - d) + d;
                        p = t.min
                    } else if (v <= p && v < t.min) {
                        if (p < t.min)continue;
                        m = (t.min - p) / (v - p) * (m - d) + d;
                        v = t.min
                    }
                    if (p >= v && p > t.max) {
                        if (v > t.max)continue;
                        d = (t.max - p) / (v - p) * (m - d) + d;
                        p = t.max
                    } else if (v >= p && v > t.max) {
                        if (p > t.max)continue;
                        m = (t.max - p) / (v - p) * (m - d) + d;
                        v = t.max
                    }
                    if (!a) {
                        h.beginPath();
                        h.moveTo(t.p2c(p), n.p2c(s));
                        a = true
                    }
                    if (d >= n.max && m >= n.max) {
                        h.lineTo(t.p2c(p), n.p2c(n.max));
                        h.lineTo(t.p2c(v), n.p2c(n.max));
                        continue
                    } else if (d <= n.min && m <= n.min) {
                        h.lineTo(t.p2c(p), n.p2c(n.min));
                        h.lineTo(t.p2c(v), n.p2c(n.min));
                        continue
                    }
                    var g = p, y = v;
                    if (d <= m && d < n.min && m >= n.min) {
                        p = (n.min - d) / (m - d) * (v - p) + p;
                        d = n.min
                    } else if (m <= d && m < n.min && d >= n.min) {
                        v = (n.min - d) / (m - d) * (v - p) + p;
                        m = n.min
                    }
                    if (d >= m && d > n.max && m <= n.max) {
                        p = (n.max - d) / (m - d) * (v - p) + p;
                        d = n.max
                    } else if (m >= d && m > n.max && d <= n.max) {
                        v = (n.max - d) / (m - d) * (v - p) + p;
                        m = n.max
                    }
                    if (p != g) {
                        h.lineTo(t.p2c(g), n.p2c(d))
                    }
                    h.lineTo(t.p2c(p), n.p2c(d));
                    h.lineTo(t.p2c(v), n.p2c(m));
                    if (v != y) {
                        h.lineTo(t.p2c(v), n.p2c(m));
                        h.lineTo(t.p2c(y), n.p2c(m))
                    }
                }
            }

            h.save();
            h.translate(m.left, m.top);
            h.lineJoin = "round";
            var r = e.lines.lineWidth, i = e.shadowSize;
            if (r > 0 && i > 0) {
                h.lineWidth = i;
                h.strokeStyle = "rgba(0,0,0,0.1)";
                var s = Math.PI / 18;
                t(e.datapoints, Math.sin(s) * (r / 2 + i / 2), Math.cos(s) * (r / 2 + i / 2), e.xaxis, e.yaxis);
                h.lineWidth = i / 2;
                t(e.datapoints, Math.sin(s) * (r / 2 + i / 4), Math.cos(s) * (r / 2 + i / 4), e.xaxis, e.yaxis)
            }
            h.lineWidth = r;
            h.strokeStyle = e.color;
            var o = ut(e.lines, e.color, 0, w);
            if (o) {
                h.fillStyle = o;
                n(e.datapoints, e.xaxis, e.yaxis)
            }
            if (r > 0)t(e.datapoints, 0, 0, e.xaxis, e.yaxis);
            h.restore()
        }

        function it(e) {
            function t(e, t, n, r, i, s, o, u) {
                var a = e.points, f = e.pointsize;
                for (var l = 0; l < a.length; l += f) {
                    var c = a[l], p = a[l + 1];
                    if (c == null || c < s.min || c > s.max || p < o.min || p > o.max)continue;
                    h.beginPath();
                    c = s.p2c(c);
                    p = o.p2c(p) + r;
                    if (u == "circle")h.arc(c, p, t, 0, i ? Math.PI : Math.PI * 2, false); else u(h, c, p, t, i);
                    h.closePath();
                    if (n) {
                        h.fillStyle = n;
                        h.fill()
                    }
                    h.stroke()
                }
            }

            h.save();
            h.translate(m.left, m.top);
            var n = e.points.lineWidth, r = e.shadowSize, i = e.points.radius, s = e.points.symbol;
            if (n > 0 && r > 0) {
                var o = r / 2;
                h.lineWidth = o;
                h.strokeStyle = "rgba(0,0,0,0.1)";
                t(e.datapoints, i, null, o + o / 2, true, e.xaxis, e.yaxis, s);
                h.strokeStyle = "rgba(0,0,0,0.2)";
                t(e.datapoints, i, null, o / 2, true, e.xaxis, e.yaxis, s)
            }
            h.lineWidth = n;
            h.strokeStyle = e.color;
            t(e.datapoints, i, ut(e.points, e.color), 0, false, e.xaxis, e.yaxis, s);
            h.restore()
        }

        function st(e, t, n, r, i, s, o, u, a, f, l, c) {
            var h, p, d, v, m, g, y, b, w;
            if (l) {
                b = g = y = true;
                m = false;
                h = n;
                p = e;
                v = t + r;
                d = t + i;
                if (p < h) {
                    w = p;
                    p = h;
                    h = w;
                    m = true;
                    g = false
                }
            } else {
                m = g = y = true;
                b = false;
                h = e + r;
                p = e + i;
                d = n;
                v = t;
                if (v < d) {
                    w = v;
                    v = d;
                    d = w;
                    b = true;
                    y = false
                }
            }
            if (p < u.min || h > u.max || v < a.min || d > a.max)return;
            if (h < u.min) {
                h = u.min;
                m = false
            }
            if (p > u.max) {
                p = u.max;
                g = false
            }
            if (d < a.min) {
                d = a.min;
                b = false
            }
            if (v > a.max) {
                v = a.max;
                y = false
            }
            h = u.p2c(h);
            d = a.p2c(d);
            p = u.p2c(p);
            v = a.p2c(v);
            if (o) {
                f.beginPath();
                f.moveTo(h, d);
                f.lineTo(h, v);
                f.lineTo(p, v);
                f.lineTo(p, d);
                f.fillStyle = o(d, v);
                f.fill()
            }
            if (c > 0 && (m || g || y || b)) {
                f.beginPath();
                f.moveTo(h, d + s);
                if (m)f.lineTo(h, v + s); else f.moveTo(h, v + s);
                if (y)f.lineTo(p, v + s); else f.moveTo(p, v + s);
                if (g)f.lineTo(p, d + s); else f.moveTo(p, d + s);
                if (b)f.lineTo(h, d + s); else f.moveTo(h, d + s);
                f.stroke()
            }
        }

        function ot(e) {
            function t(t, n, r, i, s, o, u) {
                var a = t.points, f = t.pointsize;
                for (var l = 0; l < a.length; l += f) {
                    if (a[l] == null)continue;
                    st(a[l], a[l + 1], a[l + 2], n, r, i, s, o, u, h, e.bars.horizontal, e.bars.lineWidth)
                }
            }

            h.save();
            h.translate(m.left, m.top);
            h.lineWidth = e.bars.lineWidth;
            h.strokeStyle = e.color;
            var n = e.bars.align == "left" ? 0 : -e.bars.barWidth / 2;
            var r = e.bars.fill ? function (t, n) {
                return ut(e.bars, e.color, t, n)
            } : null;
            t(e.datapoints, n, n + e.bars.barWidth, 0, r, e.xaxis, e.yaxis);
            h.restore()
        }

        function ut(t, n, r, i) {
            var s = t.fill;
            if (!s)return null;
            if (t.fillColor)return xt(t.fillColor, r, i, n);
            var o = e.color.parse(n);
            o.a = typeof s == "number" ? s : .4;
            o.normalize();
            return o.toString()
        }

        function at() {
            t.find(".legend").remove();
            if (!a.legend.show)return;
            var n = [], r = false, i = a.legend.labelFormatter, s, o;
            for (var f = 0; f < u.length; ++f) {
                s = u[f];
                o = s.label;
                if (!o)continue;
                if (f % a.legend.noColumns == 0) {
                    if (r)n.push("</tr>");
                    n.push("<tr>");
                    r = true
                }
                if (i)o = i(o, s);
                n.push('<td class="legendColorBox"><div style="border:1px solid ' + a.legend.labelBoxBorderColor + ';padding:1px"><div style="width:4px;height:0;border:5px solid ' + s.color + ';overflow:hidden"></div></div></td>' + '<td class="legendLabel">' + o + "</td>")
            }
            if (r)n.push("</tr>");
            if (n.length == 0)return;
            var l = '<table style="font-size:smaller;color:' + a.grid.color + '">' + n.join("") + "</table>";
            if (a.legend.container != null)e(a.legend.container).html(l); else {
                var c = "", h = a.legend.position, p = a.legend.margin;
                if (p[0] == null)p = [p, p];
                if (h.charAt(0) == "n")c += "top:" + (p[1] + m.top) + "px;"; else if (h.charAt(0) == "s")c += "bottom:" + (p[1] + m.bottom) + "px;";
                if (h.charAt(1) == "e")c += "right:" + (p[0] + m.right) + "px;"; else if (h.charAt(1) == "w")c += "left:" + (p[0] + m.left) + "px;";
                var d = e('<div class="legend">' + l.replace('style="', 'style="position:absolute;' + c + ";") + "</div>").appendTo(t);
                if (a.legend.backgroundOpacity != 0) {
                    var v = a.legend.backgroundColor;
                    if (v == null) {
                        v = a.grid.backgroundColor;
                        if (v && typeof v == "string")v = e.color.parse(v); else v = e.color.extract(d, "background-color");
                        v.a = 1;
                        v = v.toString()
                    }
                    var g = d.children();
                    e('<div style="position:absolute;width:' + g.width() + "px;height:" + g.height() + "px;" + c + "background-color:" + v + ';"> </div>').prependTo(d).css("opacity", a.legend.backgroundOpacity)
                }
            }
        }

        function ct(e, t, n) {
            var r = a.grid.mouseActiveRadius, i = r * r + 1, s = null, o = false, f, l;
            for (f = u.length - 1; f >= 0; --f) {
                if (!n(u[f]))continue;
                var c = u[f], h = c.xaxis, p = c.yaxis, d = c.datapoints.points, v = c.datapoints.pointsize, m = h.c2p(e), g = p.c2p(t), y = r / h.scale, b = r / p.scale;
                if (h.options.inverseTransform)y = Number.MAX_VALUE;
                if (p.options.inverseTransform)b = Number.MAX_VALUE;
                if (c.lines.show || c.points.show) {
                    for (l = 0; l < d.length; l += v) {
                        var w = d[l], E = d[l + 1];
                        if (w == null)continue;
                        if (w - m > y || w - m < -y || E - g > b || E - g < -b)continue;
                        var S = Math.abs(h.p2c(w) - e), x = Math.abs(p.p2c(E) - t), T = S * S + x * x;
                        if (T < i) {
                            i = T;
                            s = [f, l / v]
                        }
                    }
                }
                if (c.bars.show && !s) {
                    var N = c.bars.align == "left" ? 0 : -c.bars.barWidth / 2, C = N + c.bars.barWidth;
                    for (l = 0; l < d.length; l += v) {
                        var w = d[l], E = d[l + 1], k = d[l + 2];
                        if (w == null)continue;
                        if (u[f].bars.horizontal ? m <= Math.max(k, w) && m >= Math.min(k, w) && g >= E + N && g <= E + C : m >= w + N && m <= w + C && g >= Math.min(k, E) && g <= Math.max(k, E))s = [f, l / v]
                    }
                }
            }
            if (s) {
                f = s[0];
                l = s[1];
                v = u[f].datapoints.pointsize;
                return {
                    datapoint: u[f].datapoints.points.slice(l * v, (l + 1) * v),
                    dataIndex: l,
                    series: u[f],
                    seriesIndex: f
                }
            }
            return null
        }

        function ht(e) {
            if (a.grid.hoverable)vt("plothover", e, function (e) {
                return e["hoverable"] != false
            })
        }

        function pt(e) {
            if (a.grid.hoverable)vt("plothover", e, function (e) {
                return false
            })
        }

        function dt(e) {
            vt("plotclick", e, function (e) {
                return e["clickable"] != false
            })
        }

        function vt(e, n, r) {
            var i = c.offset(), s = n.pageX - i.left - m.left, o = n.pageY - i.top - m.top, u = O({left: s, top: o});
            u.pageX = n.pageX;
            u.pageY = n.pageY;
            var f = ct(s, o, r);
            if (f) {
                f.pageX = parseInt(f.series.xaxis.p2c(f.datapoint[0]) + i.left + m.left);
                f.pageY = parseInt(f.series.yaxis.p2c(f.datapoint[1]) + i.top + m.top)
            }
            if (a.grid.autoHighlight) {
                for (var l = 0; l < ft.length; ++l) {
                    var h = ft[l];
                    if (h.auto == e && !(f && h.series == f.series && h.point[0] == f.datapoint[0] && h.point[1] == f.datapoint[1]))bt(h.series, h.point)
                }
                if (f)yt(f.series, f.datapoint, e)
            }
            t.trigger(e, [u, f])
        }

        function mt() {
            if (!lt)lt = setTimeout(gt, 30)
        }

        function gt() {
            lt = null;
            p.save();
            p.clearRect(0, 0, g, y);
            p.translate(m.left, m.top);
            var e, t;
            for (e = 0; e < ft.length; ++e) {
                t = ft[e];
                if (t.series.bars.show)St(t.series, t.point); else Et(t.series, t.point)
            }
            p.restore();
            x(E.drawOverlay, [p])
        }

        function yt(e, t, n) {
            if (typeof e == "number")e = u[e];
            if (typeof t == "number") {
                var r = e.datapoints.pointsize;
                t = e.datapoints.points.slice(r * t, r * (t + 1))
            }
            var i = wt(e, t);
            if (i == -1) {
                ft.push({series: e, point: t, auto: n});
                mt()
            } else if (!n)ft[i].auto = false
        }

        function bt(e, t) {
            if (e == null && t == null) {
                ft = [];
                mt()
            }
            if (typeof e == "number")e = u[e];
            if (typeof t == "number")t = e.data[t];
            var n = wt(e, t);
            if (n != -1) {
                ft.splice(n, 1);
                mt()
            }
        }

        function wt(e, t) {
            for (var n = 0; n < ft.length; ++n) {
                var r = ft[n];
                if (r.series == e && r.point[0] == t[0] && r.point[1] == t[1])return n
            }
            return -1
        }

        function Et(t, n) {
            var r = n[0], i = n[1], s = t.xaxis, o = t.yaxis;
            if (r < s.min || r > s.max || i < o.min || i > o.max)return;
            var u = t.points.radius + t.points.lineWidth / 2;
            p.lineWidth = u;
            p.strokeStyle = e.color.parse(t.color).scale("a", .5).toString();
            var a = 1.5 * u, r = s.p2c(r), i = o.p2c(i);
            p.beginPath();
            if (t.points.symbol == "circle")p.arc(r, i, a, 0, 2 * Math.PI, false); else t.points.symbol(p, r, i, a, false);
            p.closePath();
            p.stroke()
        }

        function St(t, n) {
            p.lineWidth = t.bars.lineWidth;
            p.strokeStyle = e.color.parse(t.color).scale("a", .5).toString();
            var r = e.color.parse(t.color).scale("a", .5).toString();
            var i = t.bars.align == "left" ? 0 : -t.bars.barWidth / 2;
            st(n[0], n[1], n[2] || 0, i, i + t.bars.barWidth, 0, function () {
                return r
            }, t.xaxis, t.yaxis, p, t.bars.horizontal, t.bars.lineWidth)
        }

        function xt(t, n, r, i) {
            if (typeof t == "string")return t; else {
                var s = h.createLinearGradient(0, r, 0, n);
                for (var o = 0, u = t.colors.length; o < u; ++o) {
                    var a = t.colors[o];
                    if (typeof a != "string") {
                        var f = e.color.parse(i);
                        if (a.brightness != null)f = f.scale("rgb", a.brightness);
                        if (a.opacity != null)f.a *= a.opacity;
                        a = f.toString()
                    }
                    s.addColorStop(o / (u - 1), a)
                }
                return s
            }
        }

        var u = [], a = {
            colors: ["#96BB35", "#afd8f8", "#4AB6C9", "#A5C409", "#EAAC41"],
            legend: {
                show: true,
                noColumns: 1,
                labelFormatter: null,
                labelBoxBorderColor: "#eee",
                container: null,
                position: "ne",
                margin: 5,
                backgroundColor: null,
                backgroundOpacity: .85
            },
            xaxis: {
                show: null,
                position: "bottom",
                mode: null,
                color: null,
                tickColor: null,
                transform: null,
                inverseTransform: null,
                min: null,
                max: null,
                autoscaleMargin: null,
                ticks: null,
                tickFormatter: null,
                labelWidth: null,
                labelHeight: null,
                reserveSpace: null,
                tickLength: null,
                alignTicksWithAxis: null,
                tickDecimals: null,
                tickSize: null,
                minTickSize: null,
                monthNames: null,
                timeformat: null,
                twelveHourClock: false
            },
            yaxis: {autoscaleMargin: .02, position: "left"},
            xaxes: [],
            yaxes: [],
            series: {
                points: {show: false, radius: 3, lineWidth: 2, fill: true, fillColor: "#ffffff", symbol: "circle"},
                lines: {lineWidth: 2, fill: false, fillColor: null, steps: false},
                bars: {
                    show: false,
                    lineWidth: 2,
                    barWidth: 1,
                    fill: true,
                    fillColor: null,
                    align: "left",
                    horizontal: false
                },
                shadowSize: 3
            },
            grid: {
                show: true,
                aboveData: false,
                color: "#777",
                backgroundColor: null,
                borderColor: null,
                tickColor: null,
                labelMargin: 5,
                axisMargin: 8,
                borderWidth: 2,
                minBorderMargin: null,
                markings: null,
                markingsColor: "#f4f4f4",
                markingsLineWidth: 2,
                clickable: false,
                hoverable: false,
                autoHighlight: true,
                mouseActiveRadius: 10
            },
            hooks: {}
        }, f = null, l = null, c = null, h = null, p = null, d = [], v = [], m = {
            left: 0,
            right: 0,
            top: 0,
            bottom: 0
        }, g = 0, y = 0, b = 0, w = 0, E = {
            processOptions: [],
            processRawData: [],
            processDatapoints: [],
            drawSeries: [],
            draw: [],
            bindEvents: [],
            drawOverlay: [],
            shutdown: []
        }, S = this;
        S.setData = C;
        S.setupGrid = X;
        S.draw = G;
        S.getPlaceholder = function () {
            return t
        };
        S.getCanvas = function () {
            return f
        };
        S.getPlotOffset = function () {
            return m
        };
        S.width = function () {
            return b
        };
        S.height = function () {
            return w
        };
        S.offset = function () {
            var e = c.offset();
            e.left += m.left;
            e.top += m.top;
            return e
        };
        S.getData = function () {
            return u
        };
        S.getAxes = function () {
            var t = {}, n;
            e.each(d.concat(v), function (e, n) {
                if (n)t[n.direction + (n.n != 1 ? n.n : "") + "axis"] = n
            });
            return t
        };
        S.getXAxes = function () {
            return d
        };
        S.getYAxes = function () {
            return v
        };
        S.c2p = O;
        S.p2c = M;
        S.getOptions = function () {
            return a
        };
        S.highlight = yt;
        S.unhighlight = bt;
        S.triggerRedrawOverlay = mt;
        S.pointOffset = function (e) {
            return {
                left: parseInt(d[L(e, "x") - 1].p2c(+e.x) + m.left),
                top: parseInt(v[L(e, "y") - 1].p2c(+e.y) + m.top)
            }
        };
        S.shutdown = q;
        S.resize = function () {
            B();
            j(f);
            j(l)
        };
        S.hooks = E;
        T(S);
        N(s);
        F();
        C(r);
        X();
        G();
        I();
        var ft = [], lt = null
    }

    function n(e, t) {
        return t * Math.floor(e / t)
    }

    e.plot = function (n, r, i) {
        var s = new t(e(n), r, i, e.plot.plugins);
        return s
    };
    e.plot.version = "0.7";
    e.plot.plugins = [];
    e.plot.formatDate = function (e, t, n) {
        var r = function (e) {
            e = "" + e;
            return e.length == 1 ? "0" + e : e
        };
        var i = [];
        var s = false, o = false;
        var u = e.getUTCHours();
        var a = u < 12;
        if (n == null)n = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
        if (t.search(/%p|%P/) != -1) {
            if (u > 12) {
                u = u - 12
            } else if (u == 0) {
                u = 12
            }
        }
        for (var f = 0; f < t.length; ++f) {
            var l = t.charAt(f);
            if (s) {
                switch (l) {
                    case"h":
                        l = "" + u;
                        break;
                    case"H":
                        l = r(u);
                        break;
                    case"M":
                        l = r(e.getUTCMinutes());
                        break;
                    case"S":
                        l = r(e.getUTCSeconds());
                        break;
                    case"d":
                        l = "" + e.getUTCDate();
                        break;
                    case"m":
                        l = "" + (e.getUTCMonth() + 1);
                        break;
                    case"y":
                        l = "" + e.getUTCFullYear();
                        break;
                    case"b":
                        l = "" + n[e.getUTCMonth()];
                        break;
                    case"p":
                        l = a ? "" + "am" : "" + "pm";
                        break;
                    case"P":
                        l = a ? "" + "AM" : "" + "PM";
                        break;
                    case"0":
                        l = "";
                        o = true;
                        break
                }
                if (l && o) {
                    l = r(l);
                    o = false
                }
                i.push(l);
                if (!o)s = false
            } else {
                if (l == "%")s = true; else i.push(l)
            }
        }
        return i.join("")
    }
})(jQuery)