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
 * Projector for EquivalentBranch as outlined for the CQRS pattern. All event handling and query
 * handling related to EquivalentBranch are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by EquivalentBranchAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("equivalentBranch")
@Component("equivalentBranch-projector")
public class EquivalentBranchProjector extends EquivalentBranchEntityProjector {

  // core constructor
  public EquivalentBranchProjector(
      EquivalentBranchRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateEquivalentBranchEvent
   */
  @EventHandler(payloadType = CreateEquivalentBranchEvent.class)
  public void handle(CreateEquivalentBranchEvent event) {
    LOGGER.info("handling CreateEquivalentBranchEvent - " + event);
    EquivalentBranch entity = new EquivalentBranch();
    entity.setEquivalentBranchId(event.getEquivalentBranchId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UpdateEquivalentBranchEvent
   */
  @EventHandler(payloadType = UpdateEquivalentBranchEvent.class)
  public void handle(UpdateEquivalentBranchEvent event) {
    LOGGER.info("handling UpdateEquivalentBranchEvent - " + event);

    EquivalentBranch entity = new EquivalentBranch();
    entity.setEquivalentBranchId(event.getEquivalentBranchId());
    entity.setNegativeR12(event.getNegativeR12());
    entity.setNegativeR21(event.getNegativeR21());
    entity.setNegativeX12(event.getNegativeX12());
    entity.setNegativeX21(event.getNegativeX21());
    entity.setPositiveR12(event.getPositiveR12());
    entity.setPositiveR21(event.getPositiveR21());
    entity.setPositiveX12(event.getPositiveX12());
    entity.setPositiveX21(event.getPositiveX21());
    entity.setR(event.getR());
    entity.setR21(event.getR21());
    entity.setX(event.getX());
    entity.setX21(event.getX21());
    entity.setZeroR12(event.getZeroR12());
    entity.setZeroR21(event.getZeroR21());
    entity.setZeroX12(event.getZeroX12());
    entity.setZeroX21(event.getZeroX21());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event DeleteEquivalentBranchEvent
   */
  @EventHandler(payloadType = DeleteEquivalentBranchEvent.class)
  public void handle(DeleteEquivalentBranchEvent event) {
    LOGGER.info("handling DeleteEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    EquivalentBranch entity = delete(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignNegativeR12ToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignNegativeR12ToEquivalentBranchEvent.class)
  public void handle(AssignNegativeR12ToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignNegativeR12ToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity =
        assignNegativeR12(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignNegativeR12FromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignNegativeR12FromEquivalentBranchEvent.class)
  public void handle(UnAssignNegativeR12FromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignNegativeR12FromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignNegativeR12(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignNegativeR21ToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignNegativeR21ToEquivalentBranchEvent.class)
  public void handle(AssignNegativeR21ToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignNegativeR21ToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity =
        assignNegativeR21(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignNegativeR21FromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignNegativeR21FromEquivalentBranchEvent.class)
  public void handle(UnAssignNegativeR21FromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignNegativeR21FromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignNegativeR21(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignNegativeX12ToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignNegativeX12ToEquivalentBranchEvent.class)
  public void handle(AssignNegativeX12ToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignNegativeX12ToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity =
        assignNegativeX12(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignNegativeX12FromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignNegativeX12FromEquivalentBranchEvent.class)
  public void handle(UnAssignNegativeX12FromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignNegativeX12FromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignNegativeX12(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignNegativeX21ToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignNegativeX21ToEquivalentBranchEvent.class)
  public void handle(AssignNegativeX21ToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignNegativeX21ToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity =
        assignNegativeX21(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignNegativeX21FromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignNegativeX21FromEquivalentBranchEvent.class)
  public void handle(UnAssignNegativeX21FromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignNegativeX21FromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignNegativeX21(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignPositiveR12ToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignPositiveR12ToEquivalentBranchEvent.class)
  public void handle(AssignPositiveR12ToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignPositiveR12ToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity =
        assignPositiveR12(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignPositiveR12FromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignPositiveR12FromEquivalentBranchEvent.class)
  public void handle(UnAssignPositiveR12FromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignPositiveR12FromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignPositiveR12(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignPositiveR21ToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignPositiveR21ToEquivalentBranchEvent.class)
  public void handle(AssignPositiveR21ToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignPositiveR21ToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity =
        assignPositiveR21(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignPositiveR21FromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignPositiveR21FromEquivalentBranchEvent.class)
  public void handle(UnAssignPositiveR21FromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignPositiveR21FromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignPositiveR21(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignPositiveX12ToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignPositiveX12ToEquivalentBranchEvent.class)
  public void handle(AssignPositiveX12ToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignPositiveX12ToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity =
        assignPositiveX12(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignPositiveX12FromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignPositiveX12FromEquivalentBranchEvent.class)
  public void handle(UnAssignPositiveX12FromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignPositiveX12FromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignPositiveX12(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignPositiveX21ToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignPositiveX21ToEquivalentBranchEvent.class)
  public void handle(AssignPositiveX21ToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignPositiveX21ToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity =
        assignPositiveX21(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignPositiveX21FromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignPositiveX21FromEquivalentBranchEvent.class)
  public void handle(UnAssignPositiveX21FromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignPositiveX21FromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignPositiveX21(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignRToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignRToEquivalentBranchEvent.class)
  public void handle(AssignRToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignRToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity = assignR(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignRFromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignRFromEquivalentBranchEvent.class)
  public void handle(UnAssignRFromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignRFromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignR(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignR21ToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignR21ToEquivalentBranchEvent.class)
  public void handle(AssignR21ToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignR21ToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity = assignR21(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignR21FromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignR21FromEquivalentBranchEvent.class)
  public void handle(UnAssignR21FromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignR21FromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignR21(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignXToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignXToEquivalentBranchEvent.class)
  public void handle(AssignXToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignXToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity = assignX(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignXFromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignXFromEquivalentBranchEvent.class)
  public void handle(UnAssignXFromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignXFromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignX(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignX21ToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignX21ToEquivalentBranchEvent.class)
  public void handle(AssignX21ToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignX21ToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity = assignX21(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignX21FromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignX21FromEquivalentBranchEvent.class)
  public void handle(UnAssignX21FromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignX21FromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignX21(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignZeroR12ToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignZeroR12ToEquivalentBranchEvent.class)
  public void handle(AssignZeroR12ToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignZeroR12ToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity = assignZeroR12(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignZeroR12FromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignZeroR12FromEquivalentBranchEvent.class)
  public void handle(UnAssignZeroR12FromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignZeroR12FromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignZeroR12(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignZeroR21ToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignZeroR21ToEquivalentBranchEvent.class)
  public void handle(AssignZeroR21ToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignZeroR21ToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity = assignZeroR21(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignZeroR21FromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignZeroR21FromEquivalentBranchEvent.class)
  public void handle(UnAssignZeroR21FromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignZeroR21FromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignZeroR21(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignZeroX12ToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignZeroX12ToEquivalentBranchEvent.class)
  public void handle(AssignZeroX12ToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignZeroX12ToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity = assignZeroX12(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignZeroX12FromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignZeroX12FromEquivalentBranchEvent.class)
  public void handle(UnAssignZeroX12FromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignZeroX12FromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignZeroX12(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event AssignZeroX21ToEquivalentBranchEvent
   */
  @EventHandler(payloadType = AssignZeroX21ToEquivalentBranchEvent.class)
  public void handle(AssignZeroX21ToEquivalentBranchEvent event) {
    LOGGER.info("handling AssignZeroX21ToEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    EquivalentBranch entity = assignZeroX21(event.getEquivalentBranchId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /*
   * @param	event UnAssignZeroX21FromEquivalentBranchEvent
   */
  @EventHandler(payloadType = UnAssignZeroX21FromEquivalentBranchEvent.class)
  public void handle(UnAssignZeroX21FromEquivalentBranchEvent event) {
    LOGGER.info("handling UnAssignZeroX21FromEquivalentBranchEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    EquivalentBranch entity = unAssignZeroX21(event.getEquivalentBranchId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindEquivalentBranch(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllEquivalentBranch(entity);
  }

  /**
   * Method to retrieve the EquivalentBranch via an EquivalentBranchPrimaryKey.
   *
   * @param id Long
   * @return EquivalentBranch
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public EquivalentBranch handle(FindEquivalentBranchQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getEquivalentBranchId());
  }

  /**
   * Method to retrieve a collection of all EquivalentBranchs
   *
   * @param query FindAllEquivalentBranchQuery
   * @return List<EquivalentBranch>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<EquivalentBranch> handle(FindAllEquivalentBranchQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindEquivalentBranch, but only if the id matches
   *
   * @param entity EquivalentBranch
   */
  protected void emitFindEquivalentBranch(EquivalentBranch entity) {
    LOGGER.info("handling emitFindEquivalentBranch");

    queryUpdateEmitter.emit(
        FindEquivalentBranchQuery.class,
        query -> query.getFilter().getEquivalentBranchId().equals(entity.getEquivalentBranchId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllEquivalentBranch
   *
   * @param entity EquivalentBranch
   */
  protected void emitFindAllEquivalentBranch(EquivalentBranch entity) {
    LOGGER.info("handling emitFindAllEquivalentBranch");

    queryUpdateEmitter.emit(FindAllEquivalentBranchQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(EquivalentBranchProjector.class.getName());
}
