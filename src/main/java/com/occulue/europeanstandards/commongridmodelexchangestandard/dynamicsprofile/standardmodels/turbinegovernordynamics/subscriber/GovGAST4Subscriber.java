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
 * Subscriber for GovGAST4 related events. .
 *
 * @author your_name_here
 */
@Component("govGAST4-subscriber")
public class GovGAST4Subscriber extends BaseSubscriber {

  public GovGAST4Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovGAST4>, GovGAST4> govGAST4Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovGAST4Query(),
        ResponseTypes.multipleInstancesOf(GovGAST4.class),
        ResponseTypes.instanceOf(GovGAST4.class));
  }

  public SubscriptionQueryResult<GovGAST4, GovGAST4> govGAST4Subscribe(
      @DestinationVariable UUID govGAST4Id) {
    return queryGateway.subscriptionQuery(
        new FindGovGAST4Query(new LoadGovGAST4Filter(govGAST4Id)),
        ResponseTypes.instanceOf(GovGAST4.class),
        ResponseTypes.instanceOf(GovGAST4.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
