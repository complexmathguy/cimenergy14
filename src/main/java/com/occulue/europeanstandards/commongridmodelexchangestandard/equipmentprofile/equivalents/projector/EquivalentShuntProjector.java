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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for EquivalentShunt as outlined for the CQRS pattern. All event handling and query
 * handling related to EquivalentShunt are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by EquivalentShuntAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("equivalentShunt")
@Component("equivalentShunt-projector")
public class EquivalentShuntProjector extends EquivalentShuntEntityProjector {

  // core constructor
  public EquivalentShuntProjector(
      EquivalentShuntRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateEquivalentShuntEvent
   */
  @EventHandler(payloadType = CreateEquivalentShuntEvent.class)
  public void handle(CreateEquivalentShuntEvent event) {
    LOGGER.info("handling CreateEquivalentShuntEvent - " + event);
    EquivalentShunt entity = new EquivalentShunt();
    entity.setEquivalentShuntId(event.getEquivalentShuntId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentShunt(entity);
  }

  /*
   * @param	event UpdateEquivalentShuntEvent
   */
  @EventHandler(payloadType = UpdateEquivalentShuntEvent.class)
  public void handle(UpdateEquivalentShuntEvent event) {
    LOGGER.info("handling UpdateEquivalentShuntEvent - " + event);

    EquivalentShunt entity = new EquivalentShunt();
    entity.setEquivalentShuntId(event.getEquivalentShuntId());
    entity.setB(event.getB());
    entity.setG(event.getG());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentShunt(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentShunt(entity);
  }

  /*
   * @param	event DeleteEquivalentShuntEvent
   */
  @EventHandler(payloadType = DeleteEquivalentShuntEvent.class)
  public void handle(DeleteEquivalentShuntEvent event) {
    LOGGER.info("handling DeleteEquivalentShuntEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    EquivalentShunt entity = delete(event.getEquivalentShuntId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentShunt(entity);
  }

  /*
   * @param	event AssignBToEquivalentShuntEvent
   */
  @EventHandler(payloadType = AssignBToEquivalentShuntEvent.class)
  public void handle(AssignBToEquivalentShuntEvent event) {
    LOGGER.info("handling AssignBToEquivalentShuntEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentShunt entity = assignB(event.getEquivalentShuntId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentShunt(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentShunt(entity);
  }

  /*
   * @param	event UnAssignBFromEquivalentShuntEvent
   */
  @EventHandler(payloadType = UnAssignBFromEquivalentShuntEvent.class)
  public void handle(UnAssignBFromEquivalentShuntEvent event) {
    LOGGER.info("handling UnAssignBFromEquivalentShuntEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentShunt entity = unAssignB(event.getEquivalentShuntId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentShunt(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentShunt(entity);
  }

  /*
   * @param	event AssignGToEquivalentShuntEvent
   */
  @EventHandler(payloadType = AssignGToEquivalentShuntEvent.class)
  public void handle(AssignGToEquivalentShuntEvent event) {
    LOGGER.info("handling AssignGToEquivalentShuntEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentShunt entity = assignG(event.getEquivalentShuntId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentShunt(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentShunt(entity);
  }

  /*
   * @param	event UnAssignGFromEquivalentShuntEvent
   */
  @EventHandler(payloadType = UnAssignGFromEquivalentShuntEvent.class)
  public void handle(UnAssignGFromEquivalentShuntEvent event) {
    LOGGER.info("handling UnAssignGFromEquivalentShuntEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentShunt entity = unAssignG(event.getEquivalentShuntId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentShunt(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentShunt(entity);
  }

  /**
   * Method to retrieve the EquivalentShunt via an EquivalentShuntPrimaryKey.
   *
   * @param id Long
   * @return EquivalentShunt
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public EquivalentShunt handle(FindEquivalentShuntQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getEquivalentShuntId());
  }

  /**
   * Method to retrieve a collection of all EquivalentShunts
   *
   * @param query FindAllEquivalentShuntQuery
   * @return List<EquivalentShunt>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<EquivalentShunt> handle(FindAllEquivalentShuntQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindEquivalentShunt, but only if the id matches
   *
   * @param entity EquivalentShunt
   */
  protected void emitFindEquivalentShunt(EquivalentShunt entity) {
    LOGGER.info("handling emitFindEquivalentShunt");

    queryUpdateEmitter.emit(
        FindEquivalentShuntQuery.class,
        query -> query.getFilter().getEquivalentShuntId().equals(entity.getEquivalentShuntId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllEquivalentShunt
   *
   * @param entity EquivalentShunt
   */
  protected void emitFindAllEquivalentShunt(EquivalentShunt entity) {
    LOGGER.info("handling emitFindAllEquivalentShunt");

    queryUpdateEmitter.emit(FindAllEquivalentShuntQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(EquivalentShuntProjector.class.getName());
}
