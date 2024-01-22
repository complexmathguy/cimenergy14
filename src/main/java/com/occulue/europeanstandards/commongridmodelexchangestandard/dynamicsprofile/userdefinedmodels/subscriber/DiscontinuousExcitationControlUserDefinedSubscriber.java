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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.subscriber;

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
 * Subscriber for DiscontinuousExcitationControlUserDefined related events. .
 *
 * @author your_name_here
 */
@Component("discontinuousExcitationControlUserDefined-subscriber")
public class DiscontinuousExcitationControlUserDefinedSubscriber extends BaseSubscriber {

  public DiscontinuousExcitationControlUserDefinedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<
          List<DiscontinuousExcitationControlUserDefined>,
          DiscontinuousExcitationControlUserDefined>
      discontinuousExcitationControlUserDefinedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDiscontinuousExcitationControlUserDefinedQuery(),
        ResponseTypes.multipleInstancesOf(DiscontinuousExcitationControlUserDefined.class),
        ResponseTypes.instanceOf(DiscontinuousExcitationControlUserDefined.class));
  }

  public SubscriptionQueryResult<
          DiscontinuousExcitationControlUserDefined, DiscontinuousExcitationControlUserDefined>
      discontinuousExcitationControlUserDefinedSubscribe(
          @DestinationVariable UUID discontinuousExcitationControlUserDefinedId) {
    return queryGateway.subscriptionQuery(
        new FindDiscontinuousExcitationControlUserDefinedQuery(
            new LoadDiscontinuousExcitationControlUserDefinedFilter(
                discontinuousExcitationControlUserDefinedId)),
        ResponseTypes.instanceOf(DiscontinuousExcitationControlUserDefined.class),
        ResponseTypes.instanceOf(DiscontinuousExcitationControlUserDefined.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
