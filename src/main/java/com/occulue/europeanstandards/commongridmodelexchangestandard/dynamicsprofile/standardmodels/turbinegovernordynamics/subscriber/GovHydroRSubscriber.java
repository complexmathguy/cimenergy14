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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.subscriber;

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
 * Subscriber for GovHydroR related events. .
 *
 * @author your_name_here
 */
@Component("govHydroR-subscriber")
public class GovHydroRSubscriber extends BaseSubscriber {

  public GovHydroRSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovHydroR>, GovHydroR> govHydroRSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovHydroRQuery(),
        ResponseTypes.multipleInstancesOf(GovHydroR.class),
        ResponseTypes.instanceOf(GovHydroR.class));
  }

  public SubscriptionQueryResult<GovHydroR, GovHydroR> govHydroRSubscribe(
      @DestinationVariable UUID govHydroRId) {
    return queryGateway.subscriptionQuery(
        new FindGovHydroRQuery(new LoadGovHydroRFilter(govHydroRId)),
        ResponseTypes.instanceOf(GovHydroR.class),
        ResponseTypes.instanceOf(GovHydroR.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
