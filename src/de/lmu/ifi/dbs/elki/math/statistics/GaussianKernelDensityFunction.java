package de.lmu.ifi.dbs.elki.math.statistics;

/*
 This file is part of ELKI:
 Environment for Developing KDD-Applications Supported by Index-Structures

 Copyright (C) 2013
 Ludwig-Maximilians-Universität München
 Lehr- und Forschungseinheit für Datenbanksysteme
 ELKI Development Team

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import de.lmu.ifi.dbs.elki.math.MathUtil;
import de.lmu.ifi.dbs.elki.utilities.optionhandling.AbstractParameterizer;

/**
 * Gaussian kernel density estimator.
 * 
 * @author Erich Schubert
 */
public final class GaussianKernelDensityFunction implements KernelDensityFunction {
  /**
   * Static instance.
   */
  public static final GaussianKernelDensityFunction KERNEL = new GaussianKernelDensityFunction();

  /**
   * Canonical bandwidth.
   */
  public static final double CANONICAL_BANDWIDTH = .5 / MathUtil.SQRTPI;

  /**
   * Scaling constant for Gaussian kernel, to make it sum up to 1.
   */
  private static final double GSCALE = 1.0 / MathUtil.SQRTTWOPI;

  /**
   * Private, empty constructor. Use the static instance!
   */
  private GaussianKernelDensityFunction() {
    // Nothing to do.
  }

  @Override
  public double density(double delta) {
    return GSCALE * Math.exp(-.5 * delta * delta);
  }

  @Override
  public double canonicalBandwidth() {
    return CANONICAL_BANDWIDTH;
  }

  /**
   * Parameterization stub.
   * 
   * @author Erich Schubert
   * 
   * @apiviz.exclude
   */
  public static class Parameterizer extends AbstractParameterizer {
    @Override
    protected GaussianKernelDensityFunction makeInstance() {
      return KERNEL;
    }
  }
}
