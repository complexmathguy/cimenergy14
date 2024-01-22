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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * HydroPump business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of HydroPump related services in the case of a HydroPump business
 *       related service failing.
 *   <li>Exposes a simpler, uniform HydroPump interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill HydroPump business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class HydroPumpBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public HydroPumpBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * HydroPump Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return HydroPumpBusinessDelegate
   */
  public static HydroPumpBusinessDelegate getHydroPumpInstance() {
    return (new HydroPumpBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createHydroPump(CreateHydroPumpCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getHydroPumpId() == null) command.setHydroPumpId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      HydroPumpValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateHydroPumpCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateHydroPumpCommand of HydroPump is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create HydroPump - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateHydroPumpCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateHydroPump(UpdateHydroPumpCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      HydroPumpValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateHydroPumpCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save HydroPump - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteHydroPumpCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteHydroPumpCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      HydroPumpValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteHydroPumpCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete HydroPump using Id = " + command.getHydroPumpId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the HydroPump via HydroPumpFetchOneSummary
   *
   * @param summary HydroPumpFetchOneSummary
   * @return HydroPumpFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public HydroPump getHydroPump(HydroPumpFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("HydroPumpFetchOneSummary arg cannot be null");

    HydroPump entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      HydroPumpValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a HydroPump
      // --------------------------------------
      CompletableFuture<HydroPump> futureEntity =
          queryGateway.query(
              new FindHydroPumpQuery(new LoadHydroPumpFilter(summary.getHydroPumpId())),
              ResponseTypes.instanceOf(HydroPump.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate HydroPump with id " + summary.getHydroPumpId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all HydroPumps
   *
   * @return List<HydroPump>
   * @exception ProcessingException Thrown if any problems
   */
  public List<HydroPump> getAllHydroPump() throws ProcessingException {
    List<HydroPump> list = null;

    try {
      CompletableFuture<List<HydroPump>> futureList =
          queryGateway.query(
              new FindAllHydroPumpQuery(), ResponseTypes.multipleInstancesOf(HydroPump.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all HydroPump";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign HydroPump on HydroPump
   *
   * @param command AssignHydroPumpToHydroPumpCommand
   * @exception ProcessingException
   */
  public void assignHydroPump(AssignHydroPumpToHydroPumpCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getHydroPumpId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production
            .delegate.HydroPumpBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile
                .production.delegate.HydroPumpBusinessDelegate.getHydroPumpInstance();
    HydroPumpBusinessDelegate parentDelegate = HydroPumpBusinessDelegate.getHydroPumpInstance();
    UUID childId = command.getAssignment().getHydroPumpId();
    HydroPump child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      HydroPumpValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get HydroPump using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign HydroPump on HydroPump
   *
   * @param command UnAssignHydroPumpFromHydroPumpCommand
   * @exception ProcessingException
   */
  public void unAssignHydroPump(UnAssignHydroPumpFromHydroPumpCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      HydroPumpValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign HydroPump on HydroPump";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add HydroPump to HydroPumps
   *
   * @param command AssignHydroPumpsToHydroPumpCommand
   * @exception ProcessingException
   */
  public void addToHydroPumps(AssignHydroPumpsToHydroPumpCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getHydroPumpId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production
            .delegate.HydroPumpBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile
                .production.delegate.HydroPumpBusinessDelegate.getHydroPumpInstance();
    HydroPumpBusinessDelegate parentDelegate = HydroPumpBusinessDelegate.getHydroPumpInstance();
    UUID childId = command.getAddTo().getHydroPumpId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      HydroPumpValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a HydroPump as HydroPumps to HydroPump";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove HydroPump from HydroPumps
   *
   * @param command RemoveHydroPumpsFromHydroPumpCommand
   * @exception ProcessingException
   */
  public void removeFromHydroPumps(RemoveHydroPumpsFromHydroPumpCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production
            .delegate.HydroPumpBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile
                .production.delegate.HydroPumpBusinessDelegate.getHydroPumpInstance();
    UUID childId = command.getRemoveFrom().getHydroPumpId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      HydroPumpValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return HydroPump
   */
  private HydroPump load(UUID id) throws ProcessingException {
    hydroPump =
        HydroPumpBusinessDelegate.getHydroPumpInstance()
            .getHydroPump(new HydroPumpFetchOneSummary(id));
    return hydroPump;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private HydroPump hydroPump = null;
  private static final Logger LOGGER = Logger.getLogger(HydroPumpBusinessDelegate.class.getName());
}
