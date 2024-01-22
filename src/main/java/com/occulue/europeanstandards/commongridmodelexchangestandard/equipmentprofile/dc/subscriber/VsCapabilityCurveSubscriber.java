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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.subscriber;

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
 * Subscriber for VsCapabilityCurve related events. .
 *
 * @author your_name_here
 */
@Component("vsCapabilityCurve-subscriber")
public class VsCapabilityCurveSubscriber extends BaseSubscriber {

  public VsCapabilityCurveSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<VsCapabilityCurve>, VsCapabilityCurve>
      vsCapabilityCurveSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllVsCapabilityCurveQuery(),
        ResponseTypes.multipleInstancesOf(VsCapabilityCurve.class),
        ResponseTypes.instanceOf(VsCapabilityCurve.class));
  }

  public SubscriptionQueryResult<VsCapabilityCurve, VsCapabilityCurve> vsCapabilityCurveSubscribe(
      @DestinationVariable UUID vsCapabilityCurveId) {
    return queryGateway.subscriptionQuery(
        new FindVsCapabilityCurveQuery(new LoadVsCapabilityCurveFilter(vsCapabilityCurveId)),
        ResponseTypes.instanceOf(VsCapabilityCurve.class),
        ResponseTypes.instanceOf(VsCapabilityCurve.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
