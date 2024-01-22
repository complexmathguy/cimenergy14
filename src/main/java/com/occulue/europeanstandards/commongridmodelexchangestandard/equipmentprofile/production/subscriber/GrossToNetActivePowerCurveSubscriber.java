/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for GrossToNetActivePowerCurve related events. .
 *
 * @author your_name_here
 */
@Component("grossToNetActivePowerCurve-subscriber")
public class GrossToNetActivePowerCurveSubscriber extends BaseSubscriber {

  public GrossToNetActivePowerCurveSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GrossToNetActivePowerCurve>, GrossToNetActivePowerCurve>
      grossToNetActivePowerCurveSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGrossToNetActivePowerCurveQuery(),
        ResponseTypes.multipleInstancesOf(GrossToNetActivePowerCurve.class),
        ResponseTypes.instanceOf(GrossToNetActivePowerCurve.class));
  }

  public SubscriptionQueryResult<GrossToNetActivePowerCurve, GrossToNetActivePowerCurve>
      grossToNetActivePowerCurveSubscribe(@DestinationVariable UUID grossToNetActivePowerCurveId) {
    return queryGateway.subscriptionQuery(
        new FindGrossToNetActivePowerCurveQuery(
            new LoadGrossToNetActivePowerCurveFilter(grossToNetActivePowerCurveId)),
        ResponseTypes.instanceOf(GrossToNetActivePowerCurve.class),
        ResponseTypes.instanceOf(GrossToNetActivePowerCurve.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
