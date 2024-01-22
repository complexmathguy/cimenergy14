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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.subscriber;

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
 * Subscriber for ExcIEEEST1A related events. .
 *
 * @author your_name_here
 */
@Component("excIEEEST1A-subscriber")
public class ExcIEEEST1ASubscriber extends BaseSubscriber {

  public ExcIEEEST1ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcIEEEST1A>, ExcIEEEST1A> excIEEEST1ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcIEEEST1AQuery(),
        ResponseTypes.multipleInstancesOf(ExcIEEEST1A.class),
        ResponseTypes.instanceOf(ExcIEEEST1A.class));
  }

  public SubscriptionQueryResult<ExcIEEEST1A, ExcIEEEST1A> excIEEEST1ASubscribe(
      @DestinationVariable UUID excIEEEST1AId) {
    return queryGateway.subscriptionQuery(
        new FindExcIEEEST1AQuery(new LoadExcIEEEST1AFilter(excIEEEST1AId)),
        ResponseTypes.instanceOf(ExcIEEEST1A.class),
        ResponseTypes.instanceOf(ExcIEEEST1A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
