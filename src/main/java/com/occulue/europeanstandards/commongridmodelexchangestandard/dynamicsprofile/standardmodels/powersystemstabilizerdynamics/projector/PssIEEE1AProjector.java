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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PssIEEE1A as outlined for the CQRS pattern. All event handling and query handling
 * related to PssIEEE1A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by PssIEEE1AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pssIEEE1A")
@Component("pssIEEE1A-projector")
public class PssIEEE1AProjector extends PssIEEE1AEntityProjector {

  // core constructor
  public PssIEEE1AProjector(PssIEEE1ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePssIEEE1AEvent
   */
  @EventHandler(payloadType = CreatePssIEEE1AEvent.class)
  public void handle(CreatePssIEEE1AEvent event) {
    LOGGER.info("handling CreatePssIEEE1AEvent - " + event);
    PssIEEE1A entity = new PssIEEE1A();
    entity.setPssIEEE1AId(event.getPssIEEE1AId());
    entity.setInputSignalType(event.getInputSignalType());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event UpdatePssIEEE1AEvent
   */
  @EventHandler(payloadType = UpdatePssIEEE1AEvent.class)
  public void handle(UpdatePssIEEE1AEvent event) {
    LOGGER.info("handling UpdatePssIEEE1AEvent - " + event);

    PssIEEE1A entity = new PssIEEE1A();
    entity.setPssIEEE1AId(event.getPssIEEE1AId());
    entity.setA1(event.getA1());
    entity.setA2(event.getA2());
    entity.setInputSignalType(event.getInputSignalType());
    entity.setKs(event.getKs());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setT6(event.getT6());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event DeletePssIEEE1AEvent
   */
  @EventHandler(payloadType = DeletePssIEEE1AEvent.class)
  public void handle(DeletePssIEEE1AEvent event) {
    LOGGER.info("handling DeletePssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PssIEEE1A entity = delete(event.getPssIEEE1AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event AssignA1ToPssIEEE1AEvent
   */
  @EventHandler(payloadType = AssignA1ToPssIEEE1AEvent.class)
  public void handle(AssignA1ToPssIEEE1AEvent event) {
    LOGGER.info("handling AssignA1ToPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE1A entity = assignA1(event.getPssIEEE1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event UnAssignA1FromPssIEEE1AEvent
   */
  @EventHandler(payloadType = UnAssignA1FromPssIEEE1AEvent.class)
  public void handle(UnAssignA1FromPssIEEE1AEvent event) {
    LOGGER.info("handling UnAssignA1FromPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE1A entity = unAssignA1(event.getPssIEEE1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event AssignA2ToPssIEEE1AEvent
   */
  @EventHandler(payloadType = AssignA2ToPssIEEE1AEvent.class)
  public void handle(AssignA2ToPssIEEE1AEvent event) {
    LOGGER.info("handling AssignA2ToPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE1A entity = assignA2(event.getPssIEEE1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event UnAssignA2FromPssIEEE1AEvent
   */
  @EventHandler(payloadType = UnAssignA2FromPssIEEE1AEvent.class)
  public void handle(UnAssignA2FromPssIEEE1AEvent event) {
    LOGGER.info("handling UnAssignA2FromPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE1A entity = unAssignA2(event.getPssIEEE1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event AssignKsToPssIEEE1AEvent
   */
  @EventHandler(payloadType = AssignKsToPssIEEE1AEvent.class)
  public void handle(AssignKsToPssIEEE1AEvent event) {
    LOGGER.info("handling AssignKsToPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE1A entity = assignKs(event.getPssIEEE1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event UnAssignKsFromPssIEEE1AEvent
   */
  @EventHandler(payloadType = UnAssignKsFromPssIEEE1AEvent.class)
  public void handle(UnAssignKsFromPssIEEE1AEvent event) {
    LOGGER.info("handling UnAssignKsFromPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE1A entity = unAssignKs(event.getPssIEEE1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event AssignT1ToPssIEEE1AEvent
   */
  @EventHandler(payloadType = AssignT1ToPssIEEE1AEvent.class)
  public void handle(AssignT1ToPssIEEE1AEvent event) {
    LOGGER.info("handling AssignT1ToPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE1A entity = assignT1(event.getPssIEEE1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event UnAssignT1FromPssIEEE1AEvent
   */
  @EventHandler(payloadType = UnAssignT1FromPssIEEE1AEvent.class)
  public void handle(UnAssignT1FromPssIEEE1AEvent event) {
    LOGGER.info("handling UnAssignT1FromPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE1A entity = unAssignT1(event.getPssIEEE1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event AssignT2ToPssIEEE1AEvent
   */
  @EventHandler(payloadType = AssignT2ToPssIEEE1AEvent.class)
  public void handle(AssignT2ToPssIEEE1AEvent event) {
    LOGGER.info("handling AssignT2ToPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE1A entity = assignT2(event.getPssIEEE1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event UnAssignT2FromPssIEEE1AEvent
   */
  @EventHandler(payloadType = UnAssignT2FromPssIEEE1AEvent.class)
  public void handle(UnAssignT2FromPssIEEE1AEvent event) {
    LOGGER.info("handling UnAssignT2FromPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE1A entity = unAssignT2(event.getPssIEEE1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event AssignT3ToPssIEEE1AEvent
   */
  @EventHandler(payloadType = AssignT3ToPssIEEE1AEvent.class)
  public void handle(AssignT3ToPssIEEE1AEvent event) {
    LOGGER.info("handling AssignT3ToPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE1A entity = assignT3(event.getPssIEEE1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event UnAssignT3FromPssIEEE1AEvent
   */
  @EventHandler(payloadType = UnAssignT3FromPssIEEE1AEvent.class)
  public void handle(UnAssignT3FromPssIEEE1AEvent event) {
    LOGGER.info("handling UnAssignT3FromPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE1A entity = unAssignT3(event.getPssIEEE1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event AssignT4ToPssIEEE1AEvent
   */
  @EventHandler(payloadType = AssignT4ToPssIEEE1AEvent.class)
  public void handle(AssignT4ToPssIEEE1AEvent event) {
    LOGGER.info("handling AssignT4ToPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE1A entity = assignT4(event.getPssIEEE1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event UnAssignT4FromPssIEEE1AEvent
   */
  @EventHandler(payloadType = UnAssignT4FromPssIEEE1AEvent.class)
  public void handle(UnAssignT4FromPssIEEE1AEvent event) {
    LOGGER.info("handling UnAssignT4FromPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE1A entity = unAssignT4(event.getPssIEEE1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event AssignT5ToPssIEEE1AEvent
   */
  @EventHandler(payloadType = AssignT5ToPssIEEE1AEvent.class)
  public void handle(AssignT5ToPssIEEE1AEvent event) {
    LOGGER.info("handling AssignT5ToPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE1A entity = assignT5(event.getPssIEEE1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event UnAssignT5FromPssIEEE1AEvent
   */
  @EventHandler(payloadType = UnAssignT5FromPssIEEE1AEvent.class)
  public void handle(UnAssignT5FromPssIEEE1AEvent event) {
    LOGGER.info("handling UnAssignT5FromPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE1A entity = unAssignT5(event.getPssIEEE1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event AssignT6ToPssIEEE1AEvent
   */
  @EventHandler(payloadType = AssignT6ToPssIEEE1AEvent.class)
  public void handle(AssignT6ToPssIEEE1AEvent event) {
    LOGGER.info("handling AssignT6ToPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE1A entity = assignT6(event.getPssIEEE1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event UnAssignT6FromPssIEEE1AEvent
   */
  @EventHandler(payloadType = UnAssignT6FromPssIEEE1AEvent.class)
  public void handle(UnAssignT6FromPssIEEE1AEvent event) {
    LOGGER.info("handling UnAssignT6FromPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE1A entity = unAssignT6(event.getPssIEEE1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event AssignVrmaxToPssIEEE1AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToPssIEEE1AEvent.class)
  public void handle(AssignVrmaxToPssIEEE1AEvent event) {
    LOGGER.info("handling AssignVrmaxToPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE1A entity = assignVrmax(event.getPssIEEE1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromPssIEEE1AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromPssIEEE1AEvent.class)
  public void handle(UnAssignVrmaxFromPssIEEE1AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE1A entity = unAssignVrmax(event.getPssIEEE1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event AssignVrminToPssIEEE1AEvent
   */
  @EventHandler(payloadType = AssignVrminToPssIEEE1AEvent.class)
  public void handle(AssignVrminToPssIEEE1AEvent event) {
    LOGGER.info("handling AssignVrminToPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE1A entity = assignVrmin(event.getPssIEEE1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /*
   * @param	event UnAssignVrminFromPssIEEE1AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromPssIEEE1AEvent.class)
  public void handle(UnAssignVrminFromPssIEEE1AEvent event) {
    LOGGER.info("handling UnAssignVrminFromPssIEEE1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE1A entity = unAssignVrmin(event.getPssIEEE1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE1A(entity);
  }

  /**
   * Method to retrieve the PssIEEE1A via an PssIEEE1APrimaryKey.
   *
   * @param id Long
   * @return PssIEEE1A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PssIEEE1A handle(FindPssIEEE1AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPssIEEE1AId());
  }

  /**
   * Method to retrieve a collection of all PssIEEE1As
   *
   * @param query FindAllPssIEEE1AQuery
   * @return List<PssIEEE1A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PssIEEE1A> handle(FindAllPssIEEE1AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPssIEEE1A, but only if the id matches
   *
   * @param entity PssIEEE1A
   */
  protected void emitFindPssIEEE1A(PssIEEE1A entity) {
    LOGGER.info("handling emitFindPssIEEE1A");

    queryUpdateEmitter.emit(
        FindPssIEEE1AQuery.class,
        query -> query.getFilter().getPssIEEE1AId().equals(entity.getPssIEEE1AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPssIEEE1A
   *
   * @param entity PssIEEE1A
   */
  protected void emitFindAllPssIEEE1A(PssIEEE1A entity) {
    LOGGER.info("handling emitFindAllPssIEEE1A");

    queryUpdateEmitter.emit(FindAllPssIEEE1AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PssIEEE1AProjector.class.getName());
}
