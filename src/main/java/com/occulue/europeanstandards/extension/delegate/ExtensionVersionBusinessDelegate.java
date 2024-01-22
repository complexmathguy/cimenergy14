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
package com.occulue.europeanstandards.extension.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.extension.validator.*;
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
 * ExtensionVersion business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ExtensionVersion related services in the case of a
 *       ExtensionVersion business related service failing.
 *   <li>Exposes a simpler, uniform ExtensionVersion interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ExtensionVersion business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ExtensionVersionBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ExtensionVersionBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ExtensionVersion Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ExtensionVersionBusinessDelegate
   */
  public static ExtensionVersionBusinessDelegate getExtensionVersionInstance() {
    return (new ExtensionVersionBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createExtensionVersion(CreateExtensionVersionCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getExtensionVersionId() == null) command.setExtensionVersionId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExtensionVersionValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateExtensionVersionCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateExtensionVersionCommand of ExtensionVersion is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ExtensionVersion - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateExtensionVersionCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateExtensionVersion(UpdateExtensionVersionCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ExtensionVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateExtensionVersionCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ExtensionVersion - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteExtensionVersionCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteExtensionVersionCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExtensionVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteExtensionVersionCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete ExtensionVersion using Id = " + command.getExtensionVersionId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ExtensionVersion via ExtensionVersionFetchOneSummary
   *
   * @param summary ExtensionVersionFetchOneSummary
   * @return ExtensionVersionFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ExtensionVersion getExtensionVersion(ExtensionVersionFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ExtensionVersionFetchOneSummary arg cannot be null");

    ExtensionVersion entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ExtensionVersionValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ExtensionVersion
      // --------------------------------------
      CompletableFuture<ExtensionVersion> futureEntity =
          queryGateway.query(
              new FindExtensionVersionQuery(
                  new LoadExtensionVersionFilter(summary.getExtensionVersionId())),
              ResponseTypes.instanceOf(ExtensionVersion.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate ExtensionVersion with id " + summary.getExtensionVersionId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ExtensionVersions
   *
   * @return List<ExtensionVersion>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ExtensionVersion> getAllExtensionVersion() throws ProcessingException {
    List<ExtensionVersion> list = null;

    try {
      CompletableFuture<List<ExtensionVersion>> futureList =
          queryGateway.query(
              new FindAllExtensionVersionQuery(),
              ResponseTypes.multipleInstancesOf(ExtensionVersion.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ExtensionVersion";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Date on ExtensionVersion
   *
   * @param command AssignDateToExtensionVersionCommand
   * @exception ProcessingException
   */
  public void assignDate(AssignDateToExtensionVersionCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExtensionVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .DateProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .DateProxyBusinessDelegate.getDateProxyInstance();
    ExtensionVersionBusinessDelegate parentDelegate =
        ExtensionVersionBusinessDelegate.getExtensionVersionInstance();
    UUID childId = command.getAssignment().getDateProxyId();
    DateProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExtensionVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get DateProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Date on ExtensionVersion
   *
   * @param command UnAssignDateFromExtensionVersionCommand
   * @exception ProcessingException
   */
  public void unAssignDate(UnAssignDateFromExtensionVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExtensionVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Date on ExtensionVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NamespaceURI on ExtensionVersion
   *
   * @param command AssignNamespaceURIToExtensionVersionCommand
   * @exception ProcessingException
   */
  public void assignNamespaceURI(AssignNamespaceURIToExtensionVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getExtensionVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    ExtensionVersionBusinessDelegate parentDelegate =
        ExtensionVersionBusinessDelegate.getExtensionVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ExtensionVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign NamespaceURI on ExtensionVersion
   *
   * @param command UnAssignNamespaceURIFromExtensionVersionCommand
   * @exception ProcessingException
   */
  public void unAssignNamespaceURI(UnAssignNamespaceURIFromExtensionVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ExtensionVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NamespaceURI on ExtensionVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ExtensionVersion
   */
  private ExtensionVersion load(UUID id) throws ProcessingException {
    extensionVersion =
        ExtensionVersionBusinessDelegate.getExtensionVersionInstance()
            .getExtensionVersion(new ExtensionVersionFetchOneSummary(id));
    return extensionVersion;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ExtensionVersion extensionVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(ExtensionVersionBusinessDelegate.class.getName());
}
