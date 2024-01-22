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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for HydroPump as outlined for the CQRS pattern. All event handling and query handling
 * related to HydroPump are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by HydroPumpAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("hydroPump")
@Component("hydroPump-projector")
public class HydroPumpProjector extends HydroPumpEntityProjector {

  // core constructor
  public HydroPumpProjector(HydroPumpRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateHydroPumpEvent
   */
  @EventHandler(payloadType = CreateHydroPumpEvent.class)
  public void handle(CreateHydroPumpEvent event) {
    LOGGER.info("handling CreateHydroPumpEvent - " + event);
    HydroPump entity = new HydroPump();
    entity.setHydroPumpId(event.getHydroPumpId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllHydroPump(entity);
  }

  /*
   * @param	event UpdateHydroPumpEvent
   */
  @EventHandler(payloadType = UpdateHydroPumpEvent.class)
  public void handle(UpdateHydroPumpEvent event) {
    LOGGER.info("handling UpdateHydroPumpEvent - " + event);

    HydroPump entity = new HydroPump();
    entity.setHydroPumpId(event.getHydroPumpId());
    entity.setHydroPump(event.getHydroPump());
    entity.setHydroPumps(event.getHydroPumps());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindHydroPump(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllHydroPump(entity);
  }

  /*
   * @param	event DeleteHydroPumpEvent
   */
  @EventHandler(payloadType = DeleteHydroPumpEvent.class)
  public void handle(DeleteHydroPumpEvent event) {
    LOGGER.info("handling DeleteHydroPumpEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    HydroPump entity = delete(event.getHydroPumpId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllHydroPump(entity);
  }

  /*
   * @param	event AssignHydroPumpToHydroPumpEvent
   */
  @EventHandler(payloadType = AssignHydroPumpToHydroPumpEvent.class)
  public void handle(AssignHydroPumpToHydroPumpEvent event) {
    LOGGER.info("handling AssignHydroPumpToHydroPumpEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    HydroPump entity = assignHydroPump(event.getHydroPumpId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindHydroPump(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllHydroPump(entity);
  }

  /*
   * @param	event UnAssignHydroPumpFromHydroPumpEvent
   */
  @EventHandler(payloadType = UnAssignHydroPumpFromHydroPumpEvent.class)
  public void handle(UnAssignHydroPumpFromHydroPumpEvent event) {
    LOGGER.info("handling UnAssignHydroPumpFromHydroPumpEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    HydroPump entity = unAssignHydroPump(event.getHydroPumpId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindHydroPump(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllHydroPump(entity);
  }

  /*
   * @param	event AssignHydroPumpsToHydroPumpEvent
   */
  @EventHandler(payloadType = AssignHydroPumpsToHydroPumpEvent.class)
  public void handle(AssignHydroPumpsToHydroPumpEvent event) {
    LOGGER.info("handling AssignHydroPumpsToHydroPumpEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    HydroPump entity = addToHydroPumps(event.getHydroPumpId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindHydroPump(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllHydroPump(entity);
  }

  /*
   * @param	event RemoveHydroPumpsFromHydroPumpEvent
   */
  @EventHandler(payloadType = RemoveHydroPumpsFromHydroPumpEvent.class)
  public void handle(RemoveHydroPumpsFromHydroPumpEvent event) {
    LOGGER.info("handling RemoveHydroPumpsFromHydroPumpEvent - " + event);

    HydroPump entity = removeFromHydroPumps(event.getHydroPumpId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindHydroPump(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllHydroPump(entity);
  }

  /**
   * Method to retrieve the HydroPump via an HydroPumpPrimaryKey.
   *
   * @param id Long
   * @return HydroPump
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public HydroPump handle(FindHydroPumpQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getHydroPumpId());
  }

  /**
   * Method to retrieve a collection of all HydroPumps
   *
   * @param query FindAllHydroPumpQuery
   * @return List<HydroPump>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<HydroPump> handle(FindAllHydroPumpQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindHydroPump, but only if the id matches
   *
   * @param entity HydroPump
   */
  protected void emitFindHydroPump(HydroPump entity) {
    LOGGER.info("handling emitFindHydroPump");

    queryUpdateEmitter.emit(
        FindHydroPumpQuery.class,
        query -> query.getFilter().getHydroPumpId().equals(entity.getHydroPumpId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllHydroPump
   *
   * @param entity HydroPump
   */
  protected void emitFindAllHydroPump(HydroPump entity) {
    LOGGER.info("handling emitFindAllHydroPump");

    queryUpdateEmitter.emit(FindAllHydroPumpQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(HydroPumpProjector.class.getName());
}
