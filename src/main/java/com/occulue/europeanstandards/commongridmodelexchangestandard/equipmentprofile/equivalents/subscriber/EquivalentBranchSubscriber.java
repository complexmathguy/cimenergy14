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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.subscriber;

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
 * Subscriber for EquivalentBranch related events. .
 *
 * @author your_name_here
 */
@Component("equivalentBranch-subscriber")
public class EquivalentBranchSubscriber extends BaseSubscriber {

  public EquivalentBranchSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<EquivalentBranch>, EquivalentBranch>
      equivalentBranchSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllEquivalentBranchQuery(),
        ResponseTypes.multipleInstancesOf(EquivalentBranch.class),
        ResponseTypes.instanceOf(EquivalentBranch.class));
  }

  public SubscriptionQueryResult<EquivalentBranch, EquivalentBranch> equivalentBranchSubscribe(
      @DestinationVariable UUID equivalentBranchId) {
    return queryGateway.subscriptionQuery(
        new FindEquivalentBranchQuery(new LoadEquivalentBranchFilter(equivalentBranchId)),
        ResponseTypes.instanceOf(EquivalentBranch.class),
        ResponseTypes.instanceOf(EquivalentBranch.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
