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
 * Subscriber for ExcIEEEAC4A related events. .
 *
 * @author your_name_here
 */
@Component("excIEEEAC4A-subscriber")
public class ExcIEEEAC4ASubscriber extends BaseSubscriber {

  public ExcIEEEAC4ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcIEEEAC4A>, ExcIEEEAC4A> excIEEEAC4ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcIEEEAC4AQuery(),
        ResponseTypes.multipleInstancesOf(ExcIEEEAC4A.class),
        ResponseTypes.instanceOf(ExcIEEEAC4A.class));
  }

  public SubscriptionQueryResult<ExcIEEEAC4A, ExcIEEEAC4A> excIEEEAC4ASubscribe(
      @DestinationVariable UUID excIEEEAC4AId) {
    return queryGateway.subscriptionQuery(
        new FindExcIEEEAC4AQuery(new LoadExcIEEEAC4AFilter(excIEEEAC4AId)),
        ResponseTypes.instanceOf(ExcIEEEAC4A.class),
        ResponseTypes.instanceOf(ExcIEEEAC4A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
