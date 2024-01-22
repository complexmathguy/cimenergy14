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
 * Subscriber for GovGASTWD related events. .
 *
 * @author your_name_here
 */
@Component("govGASTWD-subscriber")
public class GovGASTWDSubscriber extends BaseSubscriber {

  public GovGASTWDSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovGASTWD>, GovGASTWD> govGASTWDSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovGASTWDQuery(),
        ResponseTypes.multipleInstancesOf(GovGASTWD.class),
        ResponseTypes.instanceOf(GovGASTWD.class));
  }

  public SubscriptionQueryResult<GovGASTWD, GovGASTWD> govGASTWDSubscribe(
      @DestinationVariable UUID govGASTWDId) {
    return queryGateway.subscriptionQuery(
        new FindGovGASTWDQuery(new LoadGovGASTWDFilter(govGASTWDId)),
        ResponseTypes.instanceOf(GovGASTWD.class),
        ResponseTypes.instanceOf(GovGASTWD.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
