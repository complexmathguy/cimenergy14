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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.subscriber;

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
 * Subscriber for RatioTapChangerTablePoint related events. .
 *
 * @author your_name_here
 */
@Component("ratioTapChangerTablePoint-subscriber")
public class RatioTapChangerTablePointSubscriber extends BaseSubscriber {

  public RatioTapChangerTablePointSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<RatioTapChangerTablePoint>, RatioTapChangerTablePoint>
      ratioTapChangerTablePointSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllRatioTapChangerTablePointQuery(),
        ResponseTypes.multipleInstancesOf(RatioTapChangerTablePoint.class),
        ResponseTypes.instanceOf(RatioTapChangerTablePoint.class));
  }

  public SubscriptionQueryResult<RatioTapChangerTablePoint, RatioTapChangerTablePoint>
      ratioTapChangerTablePointSubscribe(@DestinationVariable UUID ratioTapChangerTablePointId) {
    return queryGateway.subscriptionQuery(
        new FindRatioTapChangerTablePointQuery(
            new LoadRatioTapChangerTablePointFilter(ratioTapChangerTablePointId)),
        ResponseTypes.instanceOf(RatioTapChangerTablePoint.class),
        ResponseTypes.instanceOf(RatioTapChangerTablePoint.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
