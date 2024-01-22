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
 * Subscriber for GovGAST2 related events. .
 *
 * @author your_name_here
 */
@Component("govGAST2-subscriber")
public class GovGAST2Subscriber extends BaseSubscriber {

  public GovGAST2Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovGAST2>, GovGAST2> govGAST2Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovGAST2Query(),
        ResponseTypes.multipleInstancesOf(GovGAST2.class),
        ResponseTypes.instanceOf(GovGAST2.class));
  }

  public SubscriptionQueryResult<GovGAST2, GovGAST2> govGAST2Subscribe(
      @DestinationVariable UUID govGAST2Id) {
    return queryGateway.subscriptionQuery(
        new FindGovGAST2Query(new LoadGovGAST2Filter(govGAST2Id)),
        ResponseTypes.instanceOf(GovGAST2.class),
        ResponseTypes.instanceOf(GovGAST2.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
