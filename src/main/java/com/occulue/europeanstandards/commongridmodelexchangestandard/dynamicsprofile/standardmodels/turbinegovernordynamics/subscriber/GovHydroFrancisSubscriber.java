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
 * Subscriber for GovHydroFrancis related events. .
 *
 * @author your_name_here
 */
@Component("govHydroFrancis-subscriber")
public class GovHydroFrancisSubscriber extends BaseSubscriber {

  public GovHydroFrancisSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovHydroFrancis>, GovHydroFrancis>
      govHydroFrancisSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovHydroFrancisQuery(),
        ResponseTypes.multipleInstancesOf(GovHydroFrancis.class),
        ResponseTypes.instanceOf(GovHydroFrancis.class));
  }

  public SubscriptionQueryResult<GovHydroFrancis, GovHydroFrancis> govHydroFrancisSubscribe(
      @DestinationVariable UUID govHydroFrancisId) {
    return queryGateway.subscriptionQuery(
        new FindGovHydroFrancisQuery(new LoadGovHydroFrancisFilter(govHydroFrancisId)),
        ResponseTypes.instanceOf(GovHydroFrancis.class),
        ResponseTypes.instanceOf(GovHydroFrancis.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
