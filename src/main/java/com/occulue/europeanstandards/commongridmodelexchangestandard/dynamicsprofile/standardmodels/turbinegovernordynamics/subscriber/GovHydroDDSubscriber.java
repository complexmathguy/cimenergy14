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
 * Subscriber for GovHydroDD related events. .
 *
 * @author your_name_here
 */
@Component("govHydroDD-subscriber")
public class GovHydroDDSubscriber extends BaseSubscriber {

  public GovHydroDDSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovHydroDD>, GovHydroDD> govHydroDDSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovHydroDDQuery(),
        ResponseTypes.multipleInstancesOf(GovHydroDD.class),
        ResponseTypes.instanceOf(GovHydroDD.class));
  }

  public SubscriptionQueryResult<GovHydroDD, GovHydroDD> govHydroDDSubscribe(
      @DestinationVariable UUID govHydroDDId) {
    return queryGateway.subscriptionQuery(
        new FindGovHydroDDQuery(new LoadGovHydroDDFilter(govHydroDDId)),
        ResponseTypes.instanceOf(GovHydroDD.class),
        ResponseTypes.instanceOf(GovHydroDD.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
